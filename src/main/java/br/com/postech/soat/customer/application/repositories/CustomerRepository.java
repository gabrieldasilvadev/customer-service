package br.com.postech.soat.customer.application.repositories;

import br.com.postech.soat.customer.domain.entity.Customer;
import java.util.Optional;

public interface CustomerRepository {

    Customer save(Customer customer);

    Optional<Customer> findByCpf(String cpf);
    
    boolean exists(String cpf, String email, String phone);
}
