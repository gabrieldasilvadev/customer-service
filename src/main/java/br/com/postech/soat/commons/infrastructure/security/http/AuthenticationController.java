package br.com.postech.soat.commons.infrastructure.security.http;

import br.com.postech.soat.commons.infrastructure.security.AuthenticationService;
import br.com.postech.soat.commons.infrastructure.security.JwtTokenService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;
    private final JwtTokenService jwtTokenService;

    @PostMapping("/login")
    public ResponseEntity<AuthenticationResponse> login(@Valid @RequestBody AuthenticationRequest request) {
        return authenticationService.authenticateByCpf(request.cpf())
            .map(token -> ResponseEntity.ok(new AuthenticationResponse(token)))
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "CPF não cadastrado"));
    }

    @PostMapping("/refresh")
    public ResponseEntity<AuthenticationResponse> refresh(@RequestHeader(value = HttpHeaders.AUTHORIZATION, required = false) String authorization) {
        if (!StringUtils.hasText(authorization) || !authorization.startsWith("Bearer ")) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Token ausente ou inválido");
        }
        String token = authorization.substring(7);
        if (!jwtTokenService.isTokenValid(token)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Token inválido");
        }
        String subject = jwtTokenService.extractSubject(token)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Não foi possível extrair o assunto do token"));

        String newToken = jwtTokenService.generateToken(subject);
        return ResponseEntity.ok(new AuthenticationResponse(newToken));
    }
}
