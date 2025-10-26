package br.com.postech.soat.commons.infrastructure.security;

import java.time.Duration;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@Setter
@ConfigurationProperties(prefix = "security")
public class SecurityProperties {

    private final Jwt jwt = new Jwt();

    @Getter
    @Setter
    public static class Jwt {
        private String jwksUri = "http://localhost:8080/.well-known/jwks.json";
        private Duration expiration = Duration.ofHours(2);
        private String audience = "fast-food-api";
        private String algorithm = "RS256";
    }
}
