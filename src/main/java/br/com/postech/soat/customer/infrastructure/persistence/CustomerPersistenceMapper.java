package br.com.postech.soat.customer.infrastructure.persistence;

import br.com.postech.soat.customer.domain.entity.Customer;
import br.com.postech.soat.customer.domain.valueobject.CPF;
import br.com.postech.soat.customer.domain.valueobject.CustomerId;
import br.com.postech.soat.customer.domain.valueobject.Email;
import br.com.postech.soat.customer.domain.valueobject.Name;
import br.com.postech.soat.customer.domain.valueobject.Phone;
import org.springframework.stereotype.Component;

@Component
public class CustomerPersistenceMapper {

    public CustomerEntity toEntity(Customer customer) {
        return CustomerEntity.builder()
            .id(customer.getId().value())
            .name(customer.getName().value())
            .cpf(customer.getCpf().value())
            .email(customer.getEmail().value())
            .phone(customer.getPhone().value())
            .build();
    }

    public Customer toModel(CustomerEntity customerEntity) {
        return Customer.reconstitute(
            new CustomerId(customerEntity.getId()),
            new Name(customerEntity.getName()),
            new CPF(customerEntity.getCpf()),
            new Email(customerEntity.getEmail()),
            new Phone(customerEntity.getPhone())
        );
    }
}
