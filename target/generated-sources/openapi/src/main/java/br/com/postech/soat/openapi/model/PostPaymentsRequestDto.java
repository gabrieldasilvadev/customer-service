package br.com.postech.soat.openapi.model;

import java.net.URI;
import java.util.Objects;
import br.com.postech.soat.openapi.model.PaymentMethodDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.UUID;
import org.springframework.lang.Nullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * PostPaymentsRequestDto
 */

@JsonTypeName("post_payments_request")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.12.0")
public class PostPaymentsRequestDto {

  private UUID customerId;

  private UUID orderId;

  private PaymentMethodDto paymentMethod;

  private Double amount;

  public PostPaymentsRequestDto() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public PostPaymentsRequestDto(UUID customerId, UUID orderId, PaymentMethodDto paymentMethod, Double amount) {
    this.customerId = customerId;
    this.orderId = orderId;
    this.paymentMethod = paymentMethod;
    this.amount = amount;
  }

  public PostPaymentsRequestDto customerId(UUID customerId) {
    this.customerId = customerId;
    return this;
  }

  /**
   * Identificador único universal no formato UUID.
   * @return customerId
   */
  @NotNull @Valid 
  @Schema(name = "customerId", example = "241fae7b-0210-4d29-a928-90653c9a9a89", description = "Identificador único universal no formato UUID.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("customerId")
  public UUID getCustomerId() {
    return customerId;
  }

  public void setCustomerId(UUID customerId) {
    this.customerId = customerId;
  }

  public PostPaymentsRequestDto orderId(UUID orderId) {
    this.orderId = orderId;
    return this;
  }

  /**
   * Identificador único universal no formato UUID.
   * @return orderId
   */
  @NotNull @Valid 
  @Schema(name = "orderId", example = "241fae7b-0210-4d29-a928-90653c9a9a89", description = "Identificador único universal no formato UUID.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("orderId")
  public UUID getOrderId() {
    return orderId;
  }

  public void setOrderId(UUID orderId) {
    this.orderId = orderId;
  }

  public PostPaymentsRequestDto paymentMethod(PaymentMethodDto paymentMethod) {
    this.paymentMethod = paymentMethod;
    return this;
  }

  /**
   * Get paymentMethod
   * @return paymentMethod
   */
  @NotNull @Valid 
  @Schema(name = "paymentMethod", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("paymentMethod")
  public PaymentMethodDto getPaymentMethod() {
    return paymentMethod;
  }

  public void setPaymentMethod(PaymentMethodDto paymentMethod) {
    this.paymentMethod = paymentMethod;
  }

  public PostPaymentsRequestDto amount(Double amount) {
    this.amount = amount;
    return this;
  }

  /**
   * Valor monetário representado em formato brasileiro (R$), com suporte a casas decimais.
   * @return amount
   */
  @NotNull 
  @Schema(name = "amount", example = "1946.32", description = "Valor monetário representado em formato brasileiro (R$), com suporte a casas decimais.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("amount")
  public Double getAmount() {
    return amount;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PostPaymentsRequestDto postPaymentsRequest = (PostPaymentsRequestDto) o;
    return Objects.equals(this.customerId, postPaymentsRequest.customerId) &&
        Objects.equals(this.orderId, postPaymentsRequest.orderId) &&
        Objects.equals(this.paymentMethod, postPaymentsRequest.paymentMethod) &&
        Objects.equals(this.amount, postPaymentsRequest.amount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(customerId, orderId, paymentMethod, amount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PostPaymentsRequestDto {\n");
    sb.append("    customerId: ").append(toIndentedString(customerId)).append("\n");
    sb.append("    orderId: ").append(toIndentedString(orderId)).append("\n");
    sb.append("    paymentMethod: ").append(toIndentedString(paymentMethod)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
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

    private PostPaymentsRequestDto instance;

    public Builder() {
      this(new PostPaymentsRequestDto());
    }

    protected Builder(PostPaymentsRequestDto instance) {
      this.instance = instance;
    }

    protected Builder copyOf(PostPaymentsRequestDto value) { 
      this.instance.setCustomerId(value.customerId);
      this.instance.setOrderId(value.orderId);
      this.instance.setPaymentMethod(value.paymentMethod);
      this.instance.setAmount(value.amount);
      return this;
    }

    public PostPaymentsRequestDto.Builder customerId(UUID customerId) {
      this.instance.customerId(customerId);
      return this;
    }
    
    public PostPaymentsRequestDto.Builder orderId(UUID orderId) {
      this.instance.orderId(orderId);
      return this;
    }
    
    public PostPaymentsRequestDto.Builder paymentMethod(PaymentMethodDto paymentMethod) {
      this.instance.paymentMethod(paymentMethod);
      return this;
    }
    
    public PostPaymentsRequestDto.Builder amount(Double amount) {
      this.instance.amount(amount);
      return this;
    }
    
    /**
    * returns a built PostPaymentsRequestDto instance.
    *
    * The builder is not reusable (NullPointerException)
    */
    public PostPaymentsRequestDto build() {
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
  public static PostPaymentsRequestDto.Builder builder() {
    return new PostPaymentsRequestDto.Builder();
  }

  /**
  * Create a builder with a shallow copy of this instance.
  */
  public PostPaymentsRequestDto.Builder toBuilder() {
    PostPaymentsRequestDto.Builder builder = new PostPaymentsRequestDto.Builder();
    return builder.copyOf(this);
  }

}

