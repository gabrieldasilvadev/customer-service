package br.com.postech.soat.openapi.model;

import java.net.URI;
import java.util.Objects;
import br.com.postech.soat.openapi.model.PaymentStatusDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import java.time.OffsetDateTime;
import java.util.UUID;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.lang.Nullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * GetPaymentsPaymentId200ResponseDto
 */

@JsonTypeName("get_payments_paymentId_200_response")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.12.0")
public class GetPaymentsPaymentId200ResponseDto {

  private UUID orderId;

  private UUID paymentId;

  private Double amount;

  private PaymentStatusDto paymentStatus;

  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private OffsetDateTime processedAt;

  public GetPaymentsPaymentId200ResponseDto() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public GetPaymentsPaymentId200ResponseDto(UUID orderId, UUID paymentId, Double amount, PaymentStatusDto paymentStatus, OffsetDateTime processedAt) {
    this.orderId = orderId;
    this.paymentId = paymentId;
    this.amount = amount;
    this.paymentStatus = paymentStatus;
    this.processedAt = processedAt;
  }

  public GetPaymentsPaymentId200ResponseDto orderId(UUID orderId) {
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

  public GetPaymentsPaymentId200ResponseDto paymentId(UUID paymentId) {
    this.paymentId = paymentId;
    return this;
  }

  /**
   * Identificador único universal no formato UUID.
   * @return paymentId
   */
  @NotNull @Valid 
  @Schema(name = "paymentId", example = "241fae7b-0210-4d29-a928-90653c9a9a89", description = "Identificador único universal no formato UUID.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("paymentId")
  public UUID getPaymentId() {
    return paymentId;
  }

  public void setPaymentId(UUID paymentId) {
    this.paymentId = paymentId;
  }

  public GetPaymentsPaymentId200ResponseDto amount(Double amount) {
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

  public GetPaymentsPaymentId200ResponseDto paymentStatus(PaymentStatusDto paymentStatus) {
    this.paymentStatus = paymentStatus;
    return this;
  }

  /**
   * Get paymentStatus
   * @return paymentStatus
   */
  @NotNull @Valid 
  @Schema(name = "paymentStatus", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("paymentStatus")
  public PaymentStatusDto getPaymentStatus() {
    return paymentStatus;
  }

  public void setPaymentStatus(PaymentStatusDto paymentStatus) {
    this.paymentStatus = paymentStatus;
  }

  public GetPaymentsPaymentId200ResponseDto processedAt(OffsetDateTime processedAt) {
    this.processedAt = processedAt;
    return this;
  }

  /**
   * Data e hora no formato ISO 8601
   * @return processedAt
   */
  @NotNull @Valid 
  @Schema(name = "processedAt", example = "2025-05-20T00:00Z", description = "Data e hora no formato ISO 8601", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("processedAt")
  public OffsetDateTime getProcessedAt() {
    return processedAt;
  }

  public void setProcessedAt(OffsetDateTime processedAt) {
    this.processedAt = processedAt;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetPaymentsPaymentId200ResponseDto getPaymentsPaymentId200Response = (GetPaymentsPaymentId200ResponseDto) o;
    return Objects.equals(this.orderId, getPaymentsPaymentId200Response.orderId) &&
        Objects.equals(this.paymentId, getPaymentsPaymentId200Response.paymentId) &&
        Objects.equals(this.amount, getPaymentsPaymentId200Response.amount) &&
        Objects.equals(this.paymentStatus, getPaymentsPaymentId200Response.paymentStatus) &&
        Objects.equals(this.processedAt, getPaymentsPaymentId200Response.processedAt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(orderId, paymentId, amount, paymentStatus, processedAt);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetPaymentsPaymentId200ResponseDto {\n");
    sb.append("    orderId: ").append(toIndentedString(orderId)).append("\n");
    sb.append("    paymentId: ").append(toIndentedString(paymentId)).append("\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    paymentStatus: ").append(toIndentedString(paymentStatus)).append("\n");
    sb.append("    processedAt: ").append(toIndentedString(processedAt)).append("\n");
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

    private GetPaymentsPaymentId200ResponseDto instance;

    public Builder() {
      this(new GetPaymentsPaymentId200ResponseDto());
    }

    protected Builder(GetPaymentsPaymentId200ResponseDto instance) {
      this.instance = instance;
    }

    protected Builder copyOf(GetPaymentsPaymentId200ResponseDto value) { 
      this.instance.setOrderId(value.orderId);
      this.instance.setPaymentId(value.paymentId);
      this.instance.setAmount(value.amount);
      this.instance.setPaymentStatus(value.paymentStatus);
      this.instance.setProcessedAt(value.processedAt);
      return this;
    }

    public GetPaymentsPaymentId200ResponseDto.Builder orderId(UUID orderId) {
      this.instance.orderId(orderId);
      return this;
    }
    
    public GetPaymentsPaymentId200ResponseDto.Builder paymentId(UUID paymentId) {
      this.instance.paymentId(paymentId);
      return this;
    }
    
    public GetPaymentsPaymentId200ResponseDto.Builder amount(Double amount) {
      this.instance.amount(amount);
      return this;
    }
    
    public GetPaymentsPaymentId200ResponseDto.Builder paymentStatus(PaymentStatusDto paymentStatus) {
      this.instance.paymentStatus(paymentStatus);
      return this;
    }
    
    public GetPaymentsPaymentId200ResponseDto.Builder processedAt(OffsetDateTime processedAt) {
      this.instance.processedAt(processedAt);
      return this;
    }
    
    /**
    * returns a built GetPaymentsPaymentId200ResponseDto instance.
    *
    * The builder is not reusable (NullPointerException)
    */
    public GetPaymentsPaymentId200ResponseDto build() {
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
  public static GetPaymentsPaymentId200ResponseDto.Builder builder() {
    return new GetPaymentsPaymentId200ResponseDto.Builder();
  }

  /**
  * Create a builder with a shallow copy of this instance.
  */
  public GetPaymentsPaymentId200ResponseDto.Builder toBuilder() {
    GetPaymentsPaymentId200ResponseDto.Builder builder = new GetPaymentsPaymentId200ResponseDto.Builder();
    return builder.copyOf(this);
  }

}

