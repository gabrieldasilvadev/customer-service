package br.com.postech.soat.customer.infrastructure.persistence;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

import br.com.postech.soat.commons.infrastructure.util.MaskUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;

import java.util.UUID;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@TestPropertySource(properties = {
        "spring.flyway.enabled=false"
})
class CustomerEntityTest {

    @Autowired
    private EntityManager em;

    @Test
    @DisplayName("Deve persistir um CustomerEntity válido")
    void shouldPersistValidCustomer() {
        CustomerEntity entity = CustomerEntity.builder()
                .id(UUID.randomUUID())
                .cpf("12345678910")
                .name("João da Silva")
                .email("joao@email.com")
                .phone("11999990000")
                .build();

        em.persist(entity);
        em.flush();

        CustomerEntity found = em.find(CustomerEntity.class, entity.getId());
        assertThat(found).isNotNull();
        assertThat(found.getCpf()).isEqualTo("12345678910");
        assertThat(found.getEmail()).isEqualTo("joao@email.com");
    }

    @Test
    @DisplayName("Não deve permitir duplicated CPF")
    void shouldFailOnDuplicateCpf() {
        UUID id1 = UUID.randomUUID();
        UUID id2 = UUID.randomUUID();

        CustomerEntity c1 = CustomerEntity.builder()
                .id(id1)
                .cpf("12345678910")
                .name("João")
                .email("a@email.com")
                .phone("11111111111")
                .build();

        CustomerEntity c2 = CustomerEntity.builder()
                .id(id2)
                .cpf("12345678910") // mesmo CPF
                .name("Maria")
                .email("b@email.com")
                .phone("22222222222")
                .build();

        em.persist(c1);
        em.flush();

        em.persist(c2);

        assertThrows(PersistenceException.class, () -> em.flush());
    }

    @Test
    @DisplayName("Não deve permitir duplicated email")
    void shouldFailOnDuplicateEmail() {
        CustomerEntity c1 = CustomerEntity.builder()
                .id(UUID.randomUUID())
                .cpf("12345678910")
                .name("João")
                .email("duplicado@email.com")
                .phone("111")
                .build();

        CustomerEntity c2 = CustomerEntity.builder()
                .id(UUID.randomUUID())
                .cpf("99999999999")
                .name("Maria")
                .email("duplicado@email.com") // mesmo email
                .phone("222")
                .build();

        em.persist(c1);
        em.flush();

        em.persist(c2);
        assertThrows(PersistenceException.class, () -> em.flush());
    }

    @Test
    @DisplayName("equals deve comparar apenas ID")
    void equalsShouldOnlyCompareId() {
        UUID id = UUID.randomUUID();

        CustomerEntity e1 = CustomerEntity.builder().id(id).build();
        CustomerEntity e2 = CustomerEntity.builder().id(id).build();

        assertThat(e1).isEqualTo(e2);
        assertThat(e1.hashCode()).isEqualTo(e2.hashCode());
    }

    @Test
    @DisplayName("toString deve aplicar máscaras de CPF, email e telefone")
    void toStringShouldMaskFields() {
        CustomerEntity e = CustomerEntity.builder()
                .id(UUID.randomUUID())
                .cpf("12345678910")
                .name("João")
                .email("joao@email.com")
                .phone("11999990000")
                .build();

        String str = e.toString();

        assertThat(str).contains(MaskUtil.maskCpf("12345678910"));
        assertThat(str).contains(MaskUtil.maskEmail("joao@email.com"));
        assertThat(str).contains(MaskUtil.maskPhone("11999990000"));
    }
}
