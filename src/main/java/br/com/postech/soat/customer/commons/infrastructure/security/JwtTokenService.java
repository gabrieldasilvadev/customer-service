package br.com.postech.soat.commons.infrastructure.security;

import com.nimbusds.jose.JOSEObjectType;
import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.JWSHeader;
import com.nimbusds.jose.crypto.RSASSASigner;
import com.nimbusds.jose.crypto.RSASSAVerifier;
import com.nimbusds.jose.jwk.RSAKey;
import com.nimbusds.jwt.JWTClaimsSet;
import com.nimbusds.jwt.SignedJWT;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.time.Clock;
import java.time.Instant;
import java.util.Date;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JwtTokenService {

    private final RsaKeyProvider keyProvider;
    private final SecurityProperties securityProperties;
    private final Clock clock;

    public String generateToken(String subject) {
        try {
            Instant now = Instant.now(clock);
            Instant expiration = now.plus(securityProperties.getJwt().getExpiration());

            JWTClaimsSet claims = new JWTClaimsSet.Builder()
                .subject(subject)
                .issuer("fast-food-tech")
                .audience(securityProperties.getJwt().getAudience())
                .issueTime(Date.from(now))
                .expirationTime(Date.from(expiration))
                .build();

            RSAKey rsaKey = keyProvider.getRsaJwk();
            RSAPrivateKey privateKey = rsaKey.toRSAPrivateKey();

            JWSHeader header = new JWSHeader.Builder(JWSAlgorithm.RS256)
                .keyID(rsaKey.getKeyID())
                .type(JOSEObjectType.JWT)
                .build();

            SignedJWT signedJWT = new SignedJWT(header, claims);
            signedJWT.sign(new RSASSASigner(privateKey));

            return signedJWT.serialize();
        } catch (Exception e) {
            throw new RuntimeException("❌ Failed to generate JWT token", e);
        }
    }

    public boolean isTokenValid(String token) {
        try {
            SignedJWT signedJWT = SignedJWT.parse(token);
            RSAKey rsaKey = keyProvider.getRsaJwk();
            RSAPublicKey publicKey = rsaKey.toRSAPublicKey();
            return signedJWT.verify(new RSASSAVerifier(publicKey));
        } catch (Exception e) {
            return false;
        }
    }

    public Optional<String> extractSubject(String token) {
        try {
            SignedJWT signedJWT = SignedJWT.parse(token);
            RSAKey rsaKey = keyProvider.getRsaJwk();
            RSAPublicKey publicKey = rsaKey.toRSAPublicKey();

            if (!signedJWT.verify(new RSASSAVerifier(publicKey))) {
                return Optional.empty();
            }
            return Optional.ofNullable(signedJWT.getJWTClaimsSet().getSubject());
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
