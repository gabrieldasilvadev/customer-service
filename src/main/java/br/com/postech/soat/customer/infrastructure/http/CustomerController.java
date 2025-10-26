package br.com.postech.soat.customer.infrastructure.http;

import br.com.postech.soat.customer.application.dto.CreateCustomerDto;
import br.com.postech.soat.customer.application.dto.FindCustomerQuery;
import br.com.postech.soat.customer.application.repositories.CustomerRepository;
import br.com.postech.soat.customer.application.usecases.CreateCustomerUseCase;
import br.com.postech.soat.customer.application.usecases.FindCustomerUseCase;
import br.com.postech.soat.customer.domain.entity.Customer;
import br.com.postech.soat.openapi.api.CustomerApi;
import br.com.postech.soat.openapi.model.CreateCustomerRequestDto;
import br.com.postech.soat.openapi.model.FindCustomer200ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerController implements CustomerApi {

    private final CreateCustomerUseCase createCustomerUseCase;
    private final FindCustomerUseCase findCustomerUseCase;
    private final CustomerWebMapper customerWebMapper;

    public CustomerController(CustomerRepository customerRepository) {
        this.findCustomerUseCase = new FindCustomerUseCase(customerRepository);
        this.createCustomerUseCase = new CreateCustomerUseCase(customerRepository);
        this.customerWebMapper = new CustomerWebMapper();
    }

    @Override
    public ResponseEntity<FindCustomer200ResponseDto> createCustomer(@RequestBody CreateCustomerRequestDto createCustomerRequest) {
        CreateCustomerDto dto = customerWebMapper.toCreateCustomerDto(createCustomerRequest);

        final var customer = createCustomerUseCase.execute(dto);

        return ResponseEntity.status(HttpStatus.CREATED)
            .body(customerWebMapper.toResponse(customer));
    }

    @Override
    public ResponseEntity<FindCustomer200ResponseDto> findCustomer(String cpf) {
        FindCustomerQuery query = new FindCustomerQuery(cpf);
        Customer customer = findCustomerUseCase.execute(query);
        return ResponseEntity.ok(customerWebMapper.toResponse(customer));
    }
}