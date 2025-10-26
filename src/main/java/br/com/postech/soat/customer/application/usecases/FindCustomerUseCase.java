package br.com.postech.soat.customer.application.usecases;

import br.com.postech.soat.commons.infrastructure.exception.NotFoundException;
import br.com.postech.soat.customer.application.dto.FindCustomerQuery;
import br.com.postech.soat.customer.application.repositories.CustomerRepository;
import br.com.postech.soat.customer.domain.entity.Customer;
import br.com.postech.soat.customer.domain.valueobject.CPF;

public class FindCustomerUseCase {

    private final CustomerRepository customerRepository;

    public FindCustomerUseCase(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer execute(FindCustomerQuery query) {
        CPF cpf = new CPF(query.cpf());
        return customerRepository.findByCpf(cpf.value())
            .orElseThrow(() -> new NotFoundException("Customer not found for the document identifier: " + cpf.value()));
    }
}
