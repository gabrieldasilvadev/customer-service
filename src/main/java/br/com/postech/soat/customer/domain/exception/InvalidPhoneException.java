
package br.com.postech.soat.customer.domain.exception;

import br.com.postech.soat.commons.infrastructure.exception.BaseException;

public class InvalidPhoneException extends BaseException {
    public InvalidPhoneException(String message) {
        super(message);
    }
}
