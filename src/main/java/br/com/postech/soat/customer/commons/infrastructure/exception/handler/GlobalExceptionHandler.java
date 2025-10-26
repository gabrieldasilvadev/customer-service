package br.com.postech.soat.commons.infrastructure.exception.handler;

import br.com.postech.soat.commons.api.ErrorResponseDto;
import br.com.postech.soat.commons.infrastructure.exception.BaseException;
import br.com.postech.soat.commons.infrastructure.exception.NotFoundException;
import br.com.postech.soat.commons.infrastructure.exception.ResourceConflictException;
import br.com.postech.soat.commons.infrastructure.exception.UnprocessableEntityException;
import java.util.Collections;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleNotFoundException(NotFoundException e) {
        ErrorResponseDto errorResponse = new ErrorResponseDto()
            .status(404)
            .message("Entity not found")
            .error(Collections.singletonList(e.getMessage()));

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @ExceptionHandler(ResourceConflictException.class)
    public ResponseEntity<ErrorResponseDto> handleResourceConflictException(ResourceConflictException e) {
        ErrorResponseDto errorResponse = new ErrorResponseDto()
            .status(409)
            .message("Resource conflict")
            .error(Collections.singletonList(e.getMessage()));

        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorResponse);
    }

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ErrorResponseDto> handleDomainException(BaseException e) {
        ErrorResponseDto errorResponse = new ErrorResponseDto()
            .status(400)
            .message("Bad request")
            .error(Collections.singletonList(e.getMessage()));

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

    @ExceptionHandler(UnprocessableEntityException.class)
    public ResponseEntity<ErrorResponseDto> handleUnprocessableException(UnprocessableEntityException e) {
        ErrorResponseDto errorResponse = new ErrorResponseDto()
            .status(422)
            .message("Unprocessable Entity")
            .error(Collections.singletonList(e.getMessage()));

        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(errorResponse);
    }
}

