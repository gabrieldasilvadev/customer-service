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
 * LoginRequestDto
 */

@JsonTypeName("login_request")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.12.0")
public class LoginRequestDto {

  private String cpf;

  public LoginRequestDto() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public LoginRequestDto(String cpf) {
    this.cpf = cpf;
  }

  public LoginRequestDto cpf(String cpf) {
    this.cpf = cpf;
    return this;
  }

  /**
   * Get cpf
   * @return cpf
   */
  @NotNull 
  @Schema(name = "cpf", example = "53731833697", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("cpf")
  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    LoginRequestDto loginRequest = (LoginRequestDto) o;
    return Objects.equals(this.cpf, loginRequest.cpf);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cpf);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class LoginRequestDto {\n");
    sb.append("    cpf: ").append(toIndentedString(cpf)).append("\n");
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

    private LoginRequestDto instance;

    public Builder() {
      this(new LoginRequestDto());
    }

    protected Builder(LoginRequestDto instance) {
      this.instance = instance;
    }

    protected Builder copyOf(LoginRequestDto value) { 
      this.instance.setCpf(value.cpf);
      return this;
    }

    public LoginRequestDto.Builder cpf(String cpf) {
      this.instance.cpf(cpf);
      return this;
    }
    
    /**
    * returns a built LoginRequestDto instance.
    *
    * The builder is not reusable (NullPointerException)
    */
    public LoginRequestDto build() {
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
  public static LoginRequestDto.Builder builder() {
    return new LoginRequestDto.Builder();
  }

  /**
  * Create a builder with a shallow copy of this instance.
  */
  public LoginRequestDto.Builder toBuilder() {
    LoginRequestDto.Builder builder = new LoginRequestDto.Builder();
    return builder.copyOf(this);
  }

}

