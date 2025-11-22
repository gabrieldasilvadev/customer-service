package br.com.postech.soat.customer.infrastructure.persistence;

import br.com.postech.soat.customer.domain.entity.Customer;
import br.com.postech.soat.customer.domain.valueobject.*;
import org.junit.jupiter.api.BeforeEach;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

class CustomerRepositoryImplTest {

    private CustomerJpaRepository customerJpaRepository;
    private CustomerPersistenceMapper mapper;
    private CustomerRepositoryImpl repository;

    @BeforeEach
    void setup() {
        customerJpaRepository = mock(CustomerJpaRepository.class);
        mapper = mock(CustomerPersistenceMapper.class);
        repository = new CustomerRepositoryImpl(customerJpaRepository, mapper);
    }

    private Customer sampleDomain() {
        return Customer.reconstitute(
                new CustomerId(UUID.randomUUID()),
                new Name("João"),
                new CPF("12345678901"),
                new Email("joao@email.com"),
                new Phone("11999999999")
        );
    }

    private CustomerEntity sampleEntity() {
        return CustomerEntity.builder()
                .id(UUID.randomUUID())
                .name("João")
                .cpf("12345678901")
                .email("joao@email.com")
                .phone("11999999999")
                .build();
    }

    @Test
    void shouldSaveCustomerCorrectly() {
        Customer domain = sampleDomain();
        CustomerEntity entity = sampleEntity();

        when(mapper.toEntity(domain)).thenReturn(entity);
        when(customerJpaRepository.save(entity)).thenReturn(entity);
        when(mapper.toModel(entity)).thenReturn(domain);

        Customer saved = repository.save(domain);

        assertEquals(domain, saved);

        verify(mapper).toEntity(domain);
        verify(customerJpaRepository).save(entity);
        verify(mapper).toModel(entity);
    }

    @Test
    void shouldFindCustomerByCpf() {
        CustomerEntity entity = sampleEntity();
        Customer domain = sampleDomain();

        when(customerJpaRepository.findByCpf("12345678901"))
                .thenReturn(Optional.of(entity));

        when(mapper.toModel(entity)).thenReturn(domain);

        Optional<Customer> result = repository.findByCpf("12345678901");

        assertTrue(result.isPresent());
        assertEquals(domain, result.get());

        verify(customerJpaRepository).findByCpf("12345678901");
        verify(mapper).toModel(entity);
    }

    @Test
    void shouldReturnEmptyWhenCpfNotFound() {
        when(customerJpaRepository.findByCpf("000")).thenReturn(Optional.empty());

        Optional<Customer> result = repository.findByCpf("000");

        assertTrue(result.isEmpty());

        verify(customerJpaRepository).findByCpf("000");
        verify(mapper, never()).toModel(any());
    }

    @Test
    void shouldReturnExistsCorrectly() {
        when(customerJpaRepository.existsByCpfOrEmailOrPhone(
                "111", "a@a.com", "9999"))
                .thenReturn(true);

        boolean exists = repository.exists("111", "a@a.com", "9999");

        assertTrue(exists);

        verify(customerJpaRepository)
                .existsByCpfOrEmailOrPhone("111", "a@a.com", "9999");
    }

}