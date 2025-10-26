package br.com.postech.soat.commons.infrastructure.security;

import br.com.postech.soat.customer.application.repositories.CustomerRepository;
import br.com.postech.soat.customer.domain.valueobject.CPF;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final CustomerRepository customerRepository;
    private final JwtTokenService jwtTokenService;

    public Optional<String> authenticateByCpf(String cpf) {
        CPF document = new CPF(cpf);
        return customerRepository.findByCpf(document.value())
            .map(customer -> jwtTokenService.generateToken(customer.getCpf().value()));
    }
}
