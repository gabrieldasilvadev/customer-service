package br.com.postech.soat.customer.application.dto;

public record CreateCustomerDto(String name, String email, String cpf, String phone) {
}
