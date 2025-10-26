package br.com.postech.soat.commons.infrastructure;

import br.com.postech.soat.commons.domain.DomainEvent;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.time.Instant;
import java.util.UUID;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "event_store")
@Getter
@NoArgsConstructor
public class EventEntity {
    @Id
    @Column(name = "id", nullable = false)
    private UUID eventId;

    @Column(name = "aggregate_id", nullable = false, columnDefinition = "UUID")
    private UUID aggregateId;

    @Column(name = "event_type", nullable = false)
    private String eventType;

    @Column(name = "payload", columnDefinition = "TEXT", nullable = false)
    private String payload;

    @Column(name = "occurred_on", nullable = false)
    private Instant occurredOn;

    @Column(name = "version", nullable = false)
    private int version;

    @Column(name = "metadata", columnDefinition = "JSONB")
    private String metadata;

    public EventEntity(DomainEvent event) {
        this.eventId = event.getEventId();
        this.aggregateId = event.getAggregateId().getValue();
        this.eventType = event.getEventType();
        this.payload = event.toPayload();
        this.occurredOn = event.getOccurredOn();
        this.version = event.getVersion();
    }
}