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
 * Login200ResponseDto
 */

@JsonTypeName("login_200_response")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.12.0")
public class Login200ResponseDto {

  private @Nullable String token;

  public Login200ResponseDto token(String token) {
    this.token = token;
    return this;
  }

  /**
   * Get token
   * @return token
   */
  
  @Schema(name = "token", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("token")
  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Login200ResponseDto login200Response = (Login200ResponseDto) o;
    return Objects.equals(this.token, login200Response.token);
  }

  @Override
  public int hashCode() {
    return Objects.hash(token);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Login200ResponseDto {\n");
    sb.append("    token: ").append(toIndentedString(token)).append("\n");
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

    private Login200ResponseDto instance;

    public Builder() {
      this(new Login200ResponseDto());
    }

    protected Builder(Login200ResponseDto instance) {
      this.instance = instance;
    }

    protected Builder copyOf(Login200ResponseDto value) { 
      this.instance.setToken(value.token);
      return this;
    }

    public Login200ResponseDto.Builder token(String token) {
      this.instance.token(token);
      return this;
    }
    
    /**
    * returns a built Login200ResponseDto instance.
    *
    * The builder is not reusable (NullPointerException)
    */
    public Login200ResponseDto build() {
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
  public static Login200ResponseDto.Builder builder() {
    return new Login200ResponseDto.Builder();
  }

  /**
  * Create a builder with a shallow copy of this instance.
  */
  public Login200ResponseDto.Builder toBuilder() {
    Login200ResponseDto.Builder builder = new Login200ResponseDto.Builder();
    return builder.copyOf(this);
  }

}

