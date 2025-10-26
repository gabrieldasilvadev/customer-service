package br.com.postech.soat.customer.domain.exception;

import br.com.postech.soat.commons.infrastructure.exception.ResourceConflictException;

public class CustomerAlreadyExistsException extends ResourceConflictException {

    public CustomerAlreadyExistsException(String message) {
        super(message);
    }
}
