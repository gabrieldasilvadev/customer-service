package br.com.postech.soat.openapi.model;

import java.net.URI;
import java.util.Objects;
import br.com.postech.soat.openapi.model.DiscountTypeDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import org.springframework.lang.Nullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * PostOrders201ResponseDiscountsInnerDto
 */

@JsonTypeName("post_orders_201_response_discounts_inner")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.12.0")
public class PostOrders201ResponseDiscountsInnerDto {

  private @Nullable DiscountTypeDto type;

  private @Nullable Double amount;

  private @Nullable String reason;

  public PostOrders201ResponseDiscountsInnerDto type(DiscountTypeDto type) {
    this.type = type;
    return this;
  }

  /**
   * Get type
   * @return type
   */
  @Valid 
  @Schema(name = "type", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("type")
  public DiscountTypeDto getType() {
    return type;
  }

  public void setType(DiscountTypeDto type) {
    this.type = type;
  }

  public PostOrders201ResponseDiscountsInnerDto amount(Double amount) {
    this.amount = amount;
    return this;
  }

  /**
   * Valor monetário representado em formato brasileiro (R$), com suporte a casas decimais.
   * @return amount
   */
  
  @Schema(name = "amount", example = "1946.32", description = "Valor monetário representado em formato brasileiro (R$), com suporte a casas decimais.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("amount")
  public Double getAmount() {
    return amount;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }

  public PostOrders201ResponseDiscountsInnerDto reason(String reason) {
    this.reason = reason;
    return this;
  }

  /**
   * Get reason
   * @return reason
   */
  
  @Schema(name = "reason", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("reason")
  public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PostOrders201ResponseDiscountsInnerDto postOrders201ResponseDiscountsInner = (PostOrders201ResponseDiscountsInnerDto) o;
    return Objects.equals(this.type, postOrders201ResponseDiscountsInner.type) &&
        Objects.equals(this.amount, postOrders201ResponseDiscountsInner.amount) &&
        Objects.equals(this.reason, postOrders201ResponseDiscountsInner.reason);
  }

  @Override
  public int hashCode() {
    return Objects.hash(type, amount, reason);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PostOrders201ResponseDiscountsInnerDto {\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    reason: ").append(toIndentedString(reason)).append("\n");
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

    private PostOrders201ResponseDiscountsInnerDto instance;

    public Builder() {
      this(new PostOrders201ResponseDiscountsInnerDto());
    }

    protected Builder(PostOrders201ResponseDiscountsInnerDto instance) {
      this.instance = instance;
    }

    protected Builder copyOf(PostOrders201ResponseDiscountsInnerDto value) { 
      this.instance.setType(value.type);
      this.instance.setAmount(value.amount);
      this.instance.setReason(value.reason);
      return this;
    }

    public PostOrders201ResponseDiscountsInnerDto.Builder type(DiscountTypeDto type) {
      this.instance.type(type);
      return this;
    }
    
    public PostOrders201ResponseDiscountsInnerDto.Builder amount(Double amount) {
      this.instance.amount(amount);
      return this;
    }
    
    public PostOrders201ResponseDiscountsInnerDto.Builder reason(String reason) {
      this.instance.reason(reason);
      return this;
    }
    
    /**
    * returns a built PostOrders201ResponseDiscountsInnerDto instance.
    *
    * The builder is not reusable (NullPointerException)
    */
    public PostOrders201ResponseDiscountsInnerDto build() {
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
  public static PostOrders201ResponseDiscountsInnerDto.Builder builder() {
    return new PostOrders201ResponseDiscountsInnerDto.Builder();
  }

  /**
  * Create a builder with a shallow copy of this instance.
  */
  public PostOrders201ResponseDiscountsInnerDto.Builder toBuilder() {
    PostOrders201ResponseDiscountsInnerDto.Builder builder = new PostOrders201ResponseDiscountsInnerDto.Builder();
    return builder.copyOf(this);
  }

}

