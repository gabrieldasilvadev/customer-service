package br.com.postech.soat.commons.infrastructure;

import br.com.postech.soat.commons.domain.DomainEvent;
import br.com.postech.soat.commons.domain.EventStore;
import br.com.postech.soat.commons.domain.Identifier;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.stereotype.Repository;

@SuppressWarnings("rawtypes")
@Repository
public class EventStoreJpa implements EventStore {

    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public void save(Identifier aggregateId, List<DomainEvent> events) {
        events.forEach(event -> em.persist(new EventEntity(event)));
    }

    @Override
    public List<DomainEvent> getEventsFor(Identifier aggregateId) {
        String jpql = "SELECT e FROM EventEntity e WHERE e.aggregateId = :aggregateId ORDER BY e.version";
        return em.createQuery(jpql, EventEntity.class)
            .setParameter("aggregateId", aggregateId.getValue())
            .getResultList()
            .stream()
            .map(this::deserializeEvent)
            .toList();
    }

    private DomainEvent deserializeEvent(EventEntity entity) {
        try {
            Class<?> eventClass = Class.forName(entity.getEventType());
            return EventSerializer.deserialize(entity.getPayload(), eventClass.asSubclass(DomainEvent.class));
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Event class not found", e);
        }
    }

    private int getCurrentVersion(Identifier aggregateId) {
        String jpql = "SELECT MAX(e.version) FROM EventEntity e WHERE e.aggregateId = :aggregateId";
        Integer version = em.createQuery(jpql, Integer.class)
            .setParameter("aggregateId", aggregateId.getValue())
            .getSingleResult();
        return version != null ? version : 0;
    }
}
