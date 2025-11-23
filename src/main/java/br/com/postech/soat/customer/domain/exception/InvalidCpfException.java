package br.com.postech.soat.customer.domain.exception;

import br.com.postech.soat.commons.infrastructure.exception.BaseException;

public class InvalidCpfException extends BaseException {
    public InvalidCpfException(String message) {
        super(message);
    }
}