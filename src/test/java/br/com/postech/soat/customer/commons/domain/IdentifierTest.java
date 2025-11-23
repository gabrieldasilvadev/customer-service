package br.com.postech.soat.customer.commons.domain;
import org.junit.jupiter.api.Test;
import br.com.postech.soat.customer.commons.domain.Identifier;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class IdentifierTest {
    static class TestIdentifier extends Identifier {
        public TestIdentifier(UUID value) {
            super(value);
        }
    }

    @Test
    void testGetValue() {
        UUID uuid = UUID.randomUUID();
        Identifier identifier = new TestIdentifier(uuid);

        assertEquals(uuid, identifier.getValue());
    }

    @Test
    void testToStringReturnsUUIDString() {
        UUID uuid = UUID.randomUUID();
        Identifier identifier = new TestIdentifier(uuid);

        assertEquals(uuid.toString(), identifier.toString());
    }

    @Test
    void testEqualsSameValueShouldBeEqual() {
        UUID uuid = UUID.randomUUID();
        Identifier id1 = new TestIdentifier(uuid);
        Identifier id2 = new TestIdentifier(uuid);

        assertEquals(id1, id2);
        assertEquals(id2, id1);
    }

    @Test
    void testEqualsDifferentValueShouldNotBeEqual() {
        Identifier id1 = new TestIdentifier(UUID.randomUUID());
        Identifier id2 = new TestIdentifier(UUID.randomUUID());

        assertNotEquals(id1, id2);
    }

    @Test
    void testHashCodeSameValueShouldBeEqual() {
        UUID uuid = UUID.randomUUID();
        Identifier id1 = new TestIdentifier(uuid);
        Identifier id2 = new TestIdentifier(uuid);

        assertEquals(id1.hashCode(), id2.hashCode());
    }

    @Test
    void testHashCodeDifferentValueShouldNotBeEqual() {
        Identifier id1 = new TestIdentifier(UUID.randomUUID());
        Identifier id2 = new TestIdentifier(UUID.randomUUID());

        assertNotEquals(id1.hashCode(), id2.hashCode());
    }
}
