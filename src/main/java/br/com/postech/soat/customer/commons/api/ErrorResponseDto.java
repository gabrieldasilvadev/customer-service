package br.com.postech.soat.commons.api;

import java.util.List;

public class ErrorResponseDto {
    private Integer status;
    private String message;
    private List<String> error;

    public Integer getStatus() {
        return status;
    }

    public ErrorResponseDto status(Integer status) {
        this.status = status;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public ErrorResponseDto message(String message) {
        this.message = message;
        return this;
    }

    public List<String> getError() {
        return error;
    }

    public ErrorResponseDto error(List<String> error) {
        this.error = error;
        return this;
    }
}
