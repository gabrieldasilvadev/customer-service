package br.com.postech.soat.commons.infrastructure.aop.monitorable;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Tags;
import java.util.concurrent.TimeUnit;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MonitoringAspect {

    private static final Logger logger = LoggerFactory.getLogger(MonitoringAspect.class);
    private final MeterRegistry meterRegistry;

    public MonitoringAspect(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
    }

    private void safe(Runnable action) {
        try {
            action.run();
        } catch (Throwable t) {
            logger.debug("Failure when registering metric: {}", t.getMessage());
        }
    }

    @Around("@within(monitorable)")
    public Object monitor(ProceedingJoinPoint joinPoint, Monitorable monitorable) throws Throwable {
        String clazz = joinPoint.getSignature().getDeclaringType().getSimpleName();
        String method = joinPoint.getSignature().getName();
        String monitorName = monitorable.value().isBlank() ? clazz : monitorable.value();
        Tags tags = Tags.of("class", monitorName, "method", method);

        long start = System.nanoTime();
        Throwable thrown = null;

        try {
            return joinPoint.proceed();
        } catch (Throwable t) {
            thrown = t;
            throw t;
        } finally {
            long elapsed = System.nanoTime() - start;

            safe(() -> meterRegistry.counter("method.calls", tags).increment());
            safe(() -> meterRegistry.timer("method.execution", tags).record(elapsed, TimeUnit.NANOSECONDS));

            if (thrown == null) {
                safe(() -> meterRegistry.counter("method.success", tags).increment());
            } else {
                Tags errorTags = tags.and("exception", thrown.getClass().getSimpleName());
                safe(() -> meterRegistry.counter("method.errors", errorTags).increment());
            }
        }
    }
}
