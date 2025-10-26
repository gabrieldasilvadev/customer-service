package br.com.postech.soat.customer.infrastructure.persistence;

import java.util.Optional;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerJpaRepository extends JpaRepository<CustomerEntity, UUID> {

    Optional<CustomerEntity> findByCpf(String cpf);

    boolean existsByCpfOrEmailOrPhone(String cpf, String email, String phone);
}