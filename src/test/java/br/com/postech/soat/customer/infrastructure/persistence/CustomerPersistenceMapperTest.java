package br.com.postech.soat.customer.infrastructure.persistence;

import br.com.postech.soat.customer.domain.entity.Customer;
import br.com.postech.soat.customer.domain.valueobject.*;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.UUID;

class CustomerPersistenceMapperTest {

    private CustomerPersistenceMapper mapper;

    @BeforeEach
    void setup() {
        mapper = new CustomerPersistenceMapper();
    }

    @Test
    void shouldMapDomainToEntity() {
        Customer domain = Customer.reconstitute(
                new CustomerId(UUID.randomUUID()),
                new Name("João Silva"),
                new CPF("12345678901"),
                new Email("joao@email.com"),
                new Phone("11999999999")
        );

        CustomerEntity entity = mapper.toEntity(domain);

        assertEquals("João Silva", entity.getName());
        assertEquals("12345678901", entity.getCpf());
        assertEquals("joao@email.com", entity.getEmail());
        assertEquals("11999999999", entity.getPhone());
    }

    @Test
    void shouldMapEntityToDomain() {
        CustomerEntity entity = CustomerEntity.builder()
                .id(UUID.randomUUID())
                .name("Maria Souza")
                .cpf("98765432100")
                .email("maria@email.com")
                .phone("11988888888")
                .build();

        Customer domain = mapper.toModel(entity);

        assertEquals("Maria Souza", domain.getName().value());
        assertEquals("98765432100", domain.getCpf().value());
        assertEquals("maria@email.com", domain.getEmail().value());
        assertEquals("11988888888", domain.getPhone().value());
    }

    @Test
    void shouldMapDomainToEntityAndBack() {
        Customer original = Customer.reconstitute(
                new CustomerId(UUID.randomUUID()),
                new Name("Carlos"),
                new CPF("11122233344"),
                new Email("carlos@mail.com"),
                new Phone("11977777777")
        );

        CustomerEntity entity = mapper.toEntity(original);
        Customer reconstructed = mapper.toModel(entity);

        assertEquals(original.getName().value(), reconstructed.getName().value());
        assertEquals(original.getCpf().value(), reconstructed.getCpf().value());
        assertEquals(original.getEmail().value(), reconstructed.getEmail().value());
        assertEquals(original.getPhone().value(), reconstructed.getPhone().value());
    }

}