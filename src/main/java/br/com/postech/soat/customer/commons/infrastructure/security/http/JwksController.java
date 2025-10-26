package br.com.postech.soat.commons.infrastructure.security.http;

import br.com.postech.soat.commons.infrastructure.security.RsaKeyProvider;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.RSAKey;
import java.util.List;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/.well-known")
public class JwksController {

    private final RsaKeyProvider keyProvider;

    @GetMapping("/jwks.json")
    public Map<String, Object> keys() {
        RSAKey rsaKey = keyProvider.getRsaJwk();
        if (rsaKey == null) {
            return Map.of("keys", List.of());
        }
        return new JWKSet(rsaKey.toPublicJWK()).toJSONObject();
    }
}
