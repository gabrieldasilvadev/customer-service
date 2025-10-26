package br.com.postech.soat.commons.infrastructure.security;

import com.nimbusds.jose.JWSAlgorithm;
import com.nimbusds.jose.jwk.JWKSet;
import com.nimbusds.jose.jwk.KeyUse;
import com.nimbusds.jose.jwk.RSAKey;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.text.ParseException;
import java.util.Base64;
import java.util.UUID;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Getter
@Component
@Slf4j
public class RsaKeyProvider {

    private final RSAKey rsaJwk;
    private final Path keyDir;

    public RsaKeyProvider() {
        try {
            this.keyDir = Path.of(System.getProperty("user.dir"), "src", "main", "resources", "rsa");
            if (!Files.exists(keyDir)) {
                Files.createDirectories(keyDir);
            }

            Path jwkFile = keyDir.resolve("rsa-key.json");
            Path privatePem = keyDir.resolve("private.pem");
            Path publicPem = keyDir.resolve("public.pem");

            if (Files.exists(jwkFile)) {
                String json = Files.readString(jwkFile);
                this.rsaJwk = RSAKey.parse(json);
            } else {
                KeyPairGenerator gen = KeyPairGenerator.getInstance("RSA");
                gen.initialize(2048);
                KeyPair kp = gen.generateKeyPair();

                RSAKey key = new RSAKey.Builder((RSAPublicKey) kp.getPublic())
                    .privateKey((RSAPrivateKey) kp.getPrivate())
                    .keyUse(KeyUse.SIGNATURE)
                    .algorithm(JWSAlgorithm.RS256)
                    .keyID(UUID.randomUUID().toString())
                    .build();

                this.rsaJwk = key;

                Files.writeString(jwkFile, key.toJSONString(), StandardOpenOption.CREATE);

                writePem(privatePem, kp.getPrivate().getEncoded(), "PRIVATE KEY");
                writePem(publicPem, kp.getPublic().getEncoded(), "PUBLIC KEY");

                log.info("✅ RSA Key generated and saves in: {}", keyDir.toAbsolutePath());
            }

        } catch (IOException | ParseException | NoSuchAlgorithmException e) {
            throw new RuntimeException("❌ Failure when generating or loading RSA keys", e);
        }
    }

    private void writePem(Path path, byte[] keyBytes, String type) throws IOException {
        String base64 = Base64.getEncoder().encodeToString(keyBytes);
        String content = "-----BEGIN " + type + "-----\n"
            + base64.replaceAll("(.{64})", "$1\n")
            + "\n-----END " + type + "-----\n";
        Files.writeString(path, content, StandardOpenOption.CREATE);
    }

    public String getJwksJson() {
        return new JWKSet(rsaJwk.toPublicJWK()).toString();
    }
}
