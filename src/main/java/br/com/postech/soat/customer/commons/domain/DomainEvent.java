package br.com.postech.soat.commons.domain;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;
import java.util.UUID;

public abstract class DomainEvent implements Serializable {
    private final UUID eventId;
    private final Identifier aggregateId;
    private final Instant occurredOn;
    private final int version;

    protected DomainEvent(UUID eventId, Identifier aggregateId) {
        this.eventId = eventId;
        this.aggregateId = Objects.requireNonNull(aggregateId);
        this.occurredOn = Instant.now();
        this.version = 1;
    }

    public UUID getEventId() {
        return eventId;
    }

    public Identifier getAggregateId() {
        return aggregateId;
    }

    public Instant getOccurredOn() {
        return occurredOn;
    }

    public int getVersion() {
        return version;
    }

    public abstract String getEventType();

    public abstract String toPayload();

    protected String baseMetadata() {
        return String.format(
            "\"eventId\":\"%s\",\"aggregateId\":\"%s\",\"occurredOn\":\"%s\",\"version\":%d",
            eventId, aggregateId, occurredOn, version
        );
    }
}