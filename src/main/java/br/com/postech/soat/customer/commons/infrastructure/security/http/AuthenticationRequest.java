package br.com.postech.soat.commons.infrastructure.security.http;

import jakarta.validation.constraints.NotBlank;

public record AuthenticationRequest(@NotBlank String cpf) {
}
