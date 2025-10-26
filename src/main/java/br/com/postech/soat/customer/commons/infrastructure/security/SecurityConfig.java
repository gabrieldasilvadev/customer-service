package br.com.postech.soat.commons.infrastructure.security;

import com.nimbusds.jose.JOSEException;
import java.time.Clock;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableConfigurationProperties(SecurityProperties.class)
@ImportAutoConfiguration(exclude = UserDetailsServiceAutoConfiguration.class)
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
            .csrf(AbstractHttpConfigurer::disable)
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authorizeHttpRequests(auth -> auth
                .requestMatchers(
                    "/auth/**",
                    "/docs/**",
                    "/swagger-ui/**",
                    "/v3/api-docs/**",
                    "/api-docs/**",
                    "/actuator/**",
                    "/webhooks/mercado-pago/**",
                    "/.well-known/jwks.json",
                    "/openapi.yaml",
                    "/health",
                    "/health/**"
                ).permitAll()
                .requestMatchers(HttpMethod.POST, "/customers").permitAll()
                .anyRequest().authenticated()
            )
            .httpBasic(AbstractHttpConfigurer::disable)
            .formLogin(AbstractHttpConfigurer::disable)
            .oauth2ResourceServer(oauth2 -> oauth2.jwt(Customizer.withDefaults()))
            .build();
    }

    @Bean
    public JwtDecoder jwtDecoder(SecurityProperties properties, RsaKeyProvider keyProvider) {
        var jwt = properties.getJwt();

        if (jwt.getJwksUri() != null && !jwt.getJwksUri().isBlank()) {
            return NimbusJwtDecoder.withJwkSetUri(jwt.getJwksUri()).build();
        }

        var rsaKey = keyProvider.getRsaJwk();
        if (rsaKey != null) {
            try {
                return NimbusJwtDecoder.withPublicKey(rsaKey.toRSAPublicKey()).build();
            } catch (JOSEException e) {
                throw new RuntimeException("Failed to extract RSA public key from local JWK", e);
            }
        }

        throw new IllegalStateException("No JWKS URI configured and no local RSA key available for RS256 validation");
    }

    @Bean
    public Clock clock() {
        return Clock.systemUTC();
    }
}
