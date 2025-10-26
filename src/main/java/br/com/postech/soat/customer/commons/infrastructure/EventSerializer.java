package br.com.postech.soat.commons.infrastructure;

import br.com.postech.soat.commons.domain.DomainEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class EventSerializer {
    private static final ObjectMapper mapper = new ObjectMapper();

    public static String serialize(DomainEvent event) {
        try {
            return mapper.writeValueAsString(event);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to serialize event", e);
        }
    }

    public static <T extends DomainEvent> T deserialize(String payload, Class<T> eventType) {
        try {
            return mapper.readValue(payload, eventType);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to deserialize event", e);
        }
    }
}