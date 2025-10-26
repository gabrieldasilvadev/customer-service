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
 * DiscountDto
 */

@JsonTypeName("Discount")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.12.0")
public class DiscountDto {

  private Double value;

  public DiscountDto() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public DiscountDto(Double value) {
    this.value = value;
  }

  public DiscountDto value(Double value) {
    this.value = value;
    return this;
  }

  /**
   * Valor monetário representado em formato brasileiro (R$), com suporte a casas decimais.
   * @return value
   */
  @NotNull 
  @Schema(name = "value", example = "1946.32", description = "Valor monetário representado em formato brasileiro (R$), com suporte a casas decimais.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("value")
  public Double getValue() {
    return value;
  }

  public void setValue(Double value) {
    this.value = value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DiscountDto discount = (DiscountDto) o;
    return Objects.equals(this.value, discount.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DiscountDto {\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
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

    private DiscountDto instance;

    public Builder() {
      this(new DiscountDto());
    }

    protected Builder(DiscountDto instance) {
      this.instance = instance;
    }

    protected Builder copyOf(DiscountDto value) { 
      this.instance.setValue(value.value);
      return this;
    }

    public DiscountDto.Builder value(Double value) {
      this.instance.value(value);
      return this;
    }
    
    /**
    * returns a built DiscountDto instance.
    *
    * The builder is not reusable (NullPointerException)
    */
    public DiscountDto build() {
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
  public static DiscountDto.Builder builder() {
    return new DiscountDto.Builder();
  }

  /**
  * Create a builder with a shallow copy of this instance.
  */
  public DiscountDto.Builder toBuilder() {
    DiscountDto.Builder builder = new DiscountDto.Builder();
    return builder.copyOf(this);
  }

}

