package br.com.postech.soat.customer.infrastructure.http;

import br.com.postech.soat.customer.application.dto.CreateCustomerDto;
import br.com.postech.soat.customer.domain.entity.Customer;
import br.com.postech.soat.openapi.model.CreateCustomerRequestDto;
import br.com.postech.soat.openapi.model.FindCustomer200ResponseDto;

public class CustomerWebMapper {

    public CreateCustomerDto toCreateCustomerDto(CreateCustomerRequestDto request) {
        return new CreateCustomerDto(
            request.getName(),
            request.getEmail(),
            request.getCpf(),
            request.getPhone()
        );
    }

    public FindCustomer200ResponseDto toResponse(Customer customer) {
        FindCustomer200ResponseDto response = new FindCustomer200ResponseDto();
        response.setId(customer.getId().value().toString());
        response.setName(customer.getName().value());
        response.setEmail(customer.getEmail().value());
        response.setCpf(customer.getCpf().value());
        response.setPhone(customer.getPhone().value());
        return response;
    }
}