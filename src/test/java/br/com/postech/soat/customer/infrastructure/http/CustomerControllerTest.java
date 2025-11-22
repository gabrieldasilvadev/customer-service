package br.com.postech.soat.customer.infrastructure.http;

import br.com.postech.soat.customer.application.dto.CreateCustomerDto;
import br.com.postech.soat.customer.application.repositories.CustomerRepository;
import br.com.postech.soat.customer.domain.entity.Customer;
import br.com.postech.soat.customer.domain.valueobject.CustomerId;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import br.com.postech.soat.customer.domain.valueobject.CPF;
import br.com.postech.soat.customer.domain.valueobject.CustomerId;
import br.com.postech.soat.customer.domain.valueobject.Email;
import br.com.postech.soat.customer.domain.valueobject.Name;
import br.com.postech.soat.customer.domain.valueobject.Phone;

import java.util.Optional;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class CustomerControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CustomerRepository customerRepository;

    @TestConfiguration
    static class MockConfig {
        @Bean
        CustomerRepository customerRepository() {
            return Mockito.mock(CustomerRepository.class);
        }
    }

    @Test
    void shouldReturn400Customers() throws Exception {
        mockMvc.perform(get("/customers"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("Bad request"));
    }

    @Test
    void shouldReturn404Customers() throws Exception {
        mockMvc.perform(get("/customers").param("cpf", "12345678910"))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("Entity not found"));
    }

    @Test
    void shouldReturn200WhenCustomerExists() throws Exception {
        Customer customer = Customer.reconstitute(
                CustomerId.generate(),
                new Name("João da Silva"),
                new CPF("12345678910"),
                new Email("joao@email.com"),
                new Phone("11999990000")
        );

        Mockito.when(customerRepository.findByCpf("12345678910"))
                .thenReturn(Optional.of(customer));

        mockMvc.perform(get("/customers")
                        .param("cpf", "12345678910"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.cpf").value("12345678910"))
                .andExpect(jsonPath("$.name").value("João da Silva"));
    }

    @Test
    void shouldCreateCustomer() throws Exception {

        CreateCustomerDto dto = new CreateCustomerDto(
                "João da Silva",
                "12345678910",
                "joao@email.com",
                "11999990000"
        );

        Customer saved = Customer.reconstitute(
                CustomerId.generate(),
                new Name("João da Silva"),
                new CPF("12345678910"),
                new Email("joao@email.com"),
                new Phone("11999990000")
        );

        Mockito.when(customerRepository.exists(
                "12345678910",
                "joao@email.com",
                "11999990000"
        )).thenReturn(false);

        Mockito.when(customerRepository.save(Mockito.any()))
                .thenReturn(saved);

        mockMvc.perform(post("/customers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
            {
              "name": "João da Silva",
              "cpf": "12345678910",
              "email": "joao@email.com",
              "phone": "11999990000"
            }
            """))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.cpf").value("12345678910"))
                .andExpect(jsonPath("$.name").value("João da Silva"));
    }

    @Test
    void shouldCreateCustomerResponseBadRequest() throws Exception {
        mockMvc.perform(post("/customers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
            {
              "name": "João da Silva",
              "cpf": "123",
              "email": "joao@email.com",
              "phone": "11999990000"
            }
            """))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("Bad request"))
                .andExpect(jsonPath("$.error[0]").value("CPF inválido: 123"));;
    }

    @Test
    void shouldCreateCustomerEmailResponseBadRequest() throws Exception {
        mockMvc.perform(post("/customers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
            {
              "name": "João da Silva",
              "cpf": "12345678910",
              "email": "joao",
              "phone": "11999990000"
            }
            """))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("Bad request"))
                .andExpect(jsonPath("$.error[0]").value("Email inválido: joao"));;
    }

    @Test
    void shouldCreateCustomerPhoneNumberResponseBadRequest() throws Exception {
        mockMvc.perform(post("/customers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
            {
              "name": "João da Silva",
              "cpf": "12345678910",
              "email": "joao.cardoso@email.com",
              "phone": "11345"
            }
            """))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("Bad request"))
                .andExpect(jsonPath("$.error[0]").value("Formato de telefone inválido. Deve conter entre 10 e 11 dígitos numéricos."));;
    }

    @Test
    void shouldReturn409WhenCpfAlreadyExists() throws Exception {
        Mockito.when(customerRepository.exists(
                "12345678910",
                "joao@email.com",
                "11999990000"
        )).thenReturn(true);  // <--- CPF já existente
        mockMvc.perform(post("/customers")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("""
                {
                  "name": "João da Silva",
                  "cpf": "12345678910",
                  "email": "joao@email.com",
                  "phone": "11999990000"
                }
                """))
                .andExpect(status().isConflict())
                .andExpect(jsonPath("$.status").value(409))
                .andExpect(jsonPath("$.message").value("Resource conflict"))
                .andExpect(jsonPath("$.error").isArray())
                .andExpect(jsonPath("$.error[0]").value("Customer registration failed due to business rule violation"));
    }
}