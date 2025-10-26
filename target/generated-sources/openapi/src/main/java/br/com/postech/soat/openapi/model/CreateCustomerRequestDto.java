package br.com.postech.soat.openapi.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.springframework.lang.Nullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * CreateCustomerRequestDto
 */

@JsonTypeName("createCustomer_request")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.12.0")
public class CreateCustomerRequestDto {

  private String cpf;

  private String name;

  private String email;

  private @Nullable String phone;

  public CreateCustomerRequestDto() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public CreateCustomerRequestDto(String cpf, String name, String email) {
    this.cpf = cpf;
    this.name = name;
    this.email = email;
  }

  public CreateCustomerRequestDto cpf(String cpf) {
    this.cpf = cpf;
    return this;
  }

  /**
   * Get cpf
   * @return cpf
   */
  @NotNull @Pattern(regexp = "^\\d{11}$") @Size(min = 11, max = 11) 
  @Schema(name = "cpf", example = "53731833697", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("cpf")
  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public CreateCustomerRequestDto name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
   */
  @NotNull @Size(min = 3, max = 255) 
  @Schema(name = "name", example = "João Cardoso", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public CreateCustomerRequestDto email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Get email
   * @return email
   */
  @NotNull @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$") @Size(max = 255) @jakarta.validation.constraints.Email 
  @Schema(name = "email", example = "joao.cardoso@email.com", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("email")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public CreateCustomerRequestDto phone(String phone) {
    this.phone = phone;
    return this;
  }

  /**
   * Get phone
   * @return phone
   */
  @Pattern(regexp = "^(?:[1-9]{2})(?:[9]{1})?(?:[0-9]{8})$") @Size(min = 10, max = 111) 
  @Schema(name = "phone", example = "1134567890", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("phone")
  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CreateCustomerRequestDto createCustomerRequest = (CreateCustomerRequestDto) o;
    return Objects.equals(this.cpf, createCustomerRequest.cpf) &&
        Objects.equals(this.name, createCustomerRequest.name) &&
        Objects.equals(this.email, createCustomerRequest.email) &&
        Objects.equals(this.phone, createCustomerRequest.phone);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cpf, name, email, phone);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CreateCustomerRequestDto {\n");
    sb.append("    cpf: ").append(toIndentedString(cpf)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    phone: ").append(toIndentedString(phone)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
  
  public static class Builder {

    private CreateCustomerRequestDto instance;

    public Builder() {
      this(new CreateCustomerRequestDto());
    }

    protected Builder(CreateCustomerRequestDto instance) {
      this.instance = instance;
    }

    protected Builder copyOf(CreateCustomerRequestDto value) { 
      this.instance.setCpf(value.cpf);
      this.instance.setName(value.name);
      this.instance.setEmail(value.email);
      this.instance.setPhone(value.phone);
      return this;
    }

    public CreateCustomerRequestDto.Builder cpf(String cpf) {
      this.instance.cpf(cpf);
      return this;
    }
    
    public CreateCustomerRequestDto.Builder name(String name) {
      this.instance.name(name);
      return this;
    }
    
    public CreateCustomerRequestDto.Builder email(String email) {
      this.instance.email(email);
      return this;
    }
    
    public CreateCustomerRequestDto.Builder phone(String phone) {
      this.instance.phone(phone);
      return this;
    }
    
    /**
    * returns a built CreateCustomerRequestDto instance.
    *
    * The builder is not reusable (NullPointerException)
    */
    public CreateCustomerRequestDto build() {
      try {
        return this.instance;
      } finally {
        // ensure that this.instance is not reused
        this.instance = null;
      }
    }

    @Override
    public String toString() {
      return getClass() + "=(" + instance + ")";
    }
  }

  /**
  * Create a builder with no initialized field (except for the default values).
  */
  public static CreateCustomerRequestDto.Builder builder() {
    return new CreateCustomerRequestDto.Builder();
  }

  /**
  * Create a builder with a shallow copy of this instance.
  */
  public CreateCustomerRequestDto.Builder toBuilder() {
    CreateCustomerRequestDto.Builder builder = new CreateCustomerRequestDto.Builder();
    return builder.copyOf(this);
  }

}

