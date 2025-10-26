package br.com.postech.soat.customer.application.usecases;

import br.com.postech.soat.customer.application.dto.CreateCustomerDto;
import br.com.postech.soat.customer.application.repositories.CustomerRepository;
import br.com.postech.soat.customer.domain.exception.CustomerAlreadyExistsException;
import br.com.postech.soat.customer.domain.entity.Customer;
import br.com.postech.soat.customer.domain.valueobject.CPF;
import br.com.postech.soat.customer.domain.valueobject.Email;
import br.com.postech.soat.customer.domain.valueobject.Name;
import br.com.postech.soat.customer.domain.valueobject.Phone;

public class CreateCustomerUseCase {

    private final CustomerRepository customerRepository;

    public CreateCustomerUseCase(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer execute(CreateCustomerDto createCustomerDto) {
        if (customerRepository.exists(createCustomerDto.cpf(), createCustomerDto.email(), createCustomerDto.phone())) {
            throw new CustomerAlreadyExistsException("Customer registration failed due to business rule violation");
        }

        CPF cpf = new CPF(createCustomerDto.cpf());
        Name name = new Name(createCustomerDto.name());
        Email email = new Email(createCustomerDto.email());
        Phone phone = new Phone(createCustomerDto.phone());

        final Customer customer = Customer.create(name, email, cpf, phone);

        return customerRepository.save(customer);
    }
}