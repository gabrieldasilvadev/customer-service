
package br.com.postech.soat.customer.domain.valueobject;

import br.com.postech.soat.customer.domain.exception.InvalidCpfException;
import java.util.regex.Pattern;

public record CPF(String value) {

    private static final Pattern CPF_PATTERN = Pattern.compile("^\\d{11}$");

    public CPF(String value) {
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
        if (value == null || !CPF_PATTERN.matcher(value).matches()) {
            throw new InvalidCpfException("CPF inválido: " + value);
        }
    }
}
