package br.com.postech.soat.openapi.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.lang.Nullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Response de erro
 */

@Schema(name = "ErrorResponse", description = "Response de erro")
@JsonTypeName("ErrorResponse")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.12.0")
public class ErrorResponseDto {

  private @Nullable Integer status;

  private @Nullable String message;

  @Valid
  private List<String> error = new ArrayList<>();

  public ErrorResponseDto status(Integer status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
   */
  
  @Schema(name = "status", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("status")
  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public ErrorResponseDto message(String message) {
    this.message = message;
    return this;
  }

  /**
   * Get message
   * @return message
   */
  
  @Schema(name = "message", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("message")
  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public ErrorResponseDto error(List<String> error) {
    this.error = error;
    return this;
  }

  public ErrorResponseDto addErrorItem(String errorItem) {
    if (this.error == null) {
      this.error = new ArrayList<>();
    }
    this.error.add(errorItem);
    return this;
  }

  /**
   * Get error
   * @return error
   */
  
  @Schema(name = "error", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("error")
  public List<String> getError() {
    return error;
  }

  public void setError(List<String> error) {
    this.error = error;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ErrorResponseDto errorResponse = (ErrorResponseDto) o;
    return Objects.equals(this.status, errorResponse.status) &&
        Objects.equals(this.message, errorResponse.message) &&
        Objects.equals(this.error, errorResponse.error);
  }

  @Override
  public int hashCode() {
    return Objects.hash(status, message, error);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ErrorResponseDto {\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    message: ").append(toIndentedString(message)).append("\n");
    sb.append("    error: ").append(toIndentedString(error)).append("\n");
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

    private ErrorResponseDto instance;

    public Builder() {
      this(new ErrorResponseDto());
    }

    protected Builder(ErrorResponseDto instance) {
      this.instance = instance;
    }

    protected Builder copyOf(ErrorResponseDto value) { 
      this.instance.setStatus(value.status);
      this.instance.setMessage(value.message);
      this.instance.setError(value.error);
      return this;
    }

    public ErrorResponseDto.Builder status(Integer status) {
      this.instance.status(status);
      return this;
    }
    
    public ErrorResponseDto.Builder message(String message) {
      this.instance.message(message);
      return this;
    }
    
    public ErrorResponseDto.Builder error(List<String> error) {
      this.instance.error(error);
      return this;
    }
    
    /**
    * returns a built ErrorResponseDto instance.
    *
    * The builder is not reusable (NullPointerException)
    */
    public ErrorResponseDto build() {
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
  public static ErrorResponseDto.Builder builder() {
    return new ErrorResponseDto.Builder();
  }

  /**
  * Create a builder with a shallow copy of this instance.
  */
  public ErrorResponseDto.Builder toBuilder() {
    ErrorResponseDto.Builder builder = new ErrorResponseDto.Builder();
    return builder.copyOf(this);
  }

}

