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
 * FindCustomer200ResponseDto
 */

@JsonTypeName("findCustomer_200_response")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.12.0")
public class FindCustomer200ResponseDto {

  private @Nullable String id;

  private @Nullable String name;

  private @Nullable String email;

  private @Nullable String cpf;

  private @Nullable String phone;

  public FindCustomer200ResponseDto id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   */
  
  @Schema(name = "id", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public FindCustomer200ResponseDto name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
   */
  
  @Schema(name = "name", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public FindCustomer200ResponseDto email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Get email
   * @return email
   */
  
  @Schema(name = "email", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("email")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public FindCustomer200ResponseDto cpf(String cpf) {
    this.cpf = cpf;
    return this;
  }

  /**
   * Get cpf
   * @return cpf
   */
  
  @Schema(name = "cpf", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("cpf")
  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  public FindCustomer200ResponseDto phone(String phone) {
    this.phone = phone;
    return this;
  }

  /**
   * Get phone
   * @return phone
   */
  
  @Schema(name = "phone", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
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
    FindCustomer200ResponseDto findCustomer200Response = (FindCustomer200ResponseDto) o;
    return Objects.equals(this.id, findCustomer200Response.id) &&
        Objects.equals(this.name, findCustomer200Response.name) &&
        Objects.equals(this.email, findCustomer200Response.email) &&
        Objects.equals(this.cpf, findCustomer200Response.cpf) &&
        Objects.equals(this.phone, findCustomer200Response.phone);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, email, cpf, phone);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FindCustomer200ResponseDto {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    cpf: ").append(toIndentedString(cpf)).append("\n");
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

    private FindCustomer200ResponseDto instance;

    public Builder() {
      this(new FindCustomer200ResponseDto());
    }

    protected Builder(FindCustomer200ResponseDto instance) {
      this.instance = instance;
    }

    protected Builder copyOf(FindCustomer200ResponseDto value) { 
      this.instance.setId(value.id);
      this.instance.setName(value.name);
      this.instance.setEmail(value.email);
      this.instance.setCpf(value.cpf);
      this.instance.setPhone(value.phone);
      return this;
    }

    public FindCustomer200ResponseDto.Builder id(String id) {
      this.instance.id(id);
      return this;
    }
    
    public FindCustomer200ResponseDto.Builder name(String name) {
      this.instance.name(name);
      return this;
    }
    
    public FindCustomer200ResponseDto.Builder email(String email) {
      this.instance.email(email);
      return this;
    }
    
    public FindCustomer200ResponseDto.Builder cpf(String cpf) {
      this.instance.cpf(cpf);
      return this;
    }
    
    public FindCustomer200ResponseDto.Builder phone(String phone) {
      this.instance.phone(phone);
      return this;
    }
    
    /**
    * returns a built FindCustomer200ResponseDto instance.
    *
    * The builder is not reusable (NullPointerException)
    */
    public FindCustomer200ResponseDto build() {
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
  public static FindCustomer200ResponseDto.Builder builder() {
    return new FindCustomer200ResponseDto.Builder();
  }

  /**
  * Create a builder with a shallow copy of this instance.
  */
  public FindCustomer200ResponseDto.Builder toBuilder() {
    FindCustomer200ResponseDto.Builder builder = new FindCustomer200ResponseDto.Builder();
    return builder.copyOf(this);
  }

}

