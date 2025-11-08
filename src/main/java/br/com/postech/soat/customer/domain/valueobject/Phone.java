package br.com.postech.soat.customer.domain.valueobject;

import br.com.postech.soat.customer.domain.exception.InvalidPhoneException;
import java.util.regex.Pattern;

public record Phone(String value) {

    private static final Pattern PHONE_PATTERN = Pattern.compile("^[0-9]{10,11}$");

    public Phone(String value) {
        String normalizedValue = normalize(value);
        validate(normalizedValue);
        this.value = normalizedValue;
    }

    private String normalize(String value) {
        if (value == null) {
            return null;
        }

        return value.replaceAll("[^0-9]", "");
    }

    private void validate(String value) {
        if (value == null || !PHONE_PATTERN.matcher(value).matches()) {
            throw new InvalidPhoneException("Formato de telefone inválido. Deve conter entre 10 e 11 dígitos numéricos.");
        }
    }
}