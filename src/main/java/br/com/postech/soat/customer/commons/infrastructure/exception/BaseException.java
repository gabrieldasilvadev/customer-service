package br.com.postech.soat.commons.infrastructure.exception;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public abstract class BaseException extends RuntimeException {

    public BaseException(String message) {
        super(message);
    }

}
