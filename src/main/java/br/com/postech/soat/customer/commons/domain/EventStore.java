package br.com.postech.soat.commons.domain;

import java.util.List;

@SuppressWarnings("rawtypes")
public interface EventStore {
    void save(Identifier aggregateId, List<DomainEvent> events);
    List<DomainEvent> getEventsFor(Identifier aggregateId);
}
