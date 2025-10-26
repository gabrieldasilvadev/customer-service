package br.com.postech.soat.commons.infrastructure.util;

public class MaskUtil {

    private MaskUtil() {
    }

    public static String maskCpf(String cpf) {
        if (cpf == null || cpf.length() < 4) {
            return cpf;
        }
        return cpf.substring(0, 2) + "*****" + cpf.substring(cpf.length() - 2);
    }

    public static String maskEmail(String email) {
        if (email == null || !email.contains("@")) {
            return email;
        }

        String[] parts = email.split("@");
        String username = parts[0];

        if (username.length() <= 2) {
            return "*".repeat(username.length()) + "@" + parts[1];
        }

        return username.substring(0, 2) + "*".repeat(username.length() - 2) + "@" + parts[1];
    }

    public static String maskPhone(String phone) {
        if (phone == null) {
            return null;
        }

        if (phone.length() == 10) {
            return phone.substring(0, 2) + "******" + phone.substring(8);
        } else {
            return phone.substring(0, 3) + "*****" + phone.substring(9);
        }
    }
}