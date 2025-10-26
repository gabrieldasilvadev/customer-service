package br.com.postech.soat.openapi.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.net.URI;
import java.util.UUID;
import org.springframework.lang.Nullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Resultado da iniciação de pagamento contendo ID do pagamento e URL para redirecionamento
 */

@Schema(name = "PaymentInitiationResult", description = "Resultado da iniciação de pagamento contendo ID do pagamento e URL para redirecionamento")
@JsonTypeName("PaymentInitiationResult")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.12.0")
public class PaymentInitiationResultDto {

  private UUID paymentId;

  private @Nullable URI paymentUrl = null;

  public PaymentInitiationResultDto() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public PaymentInitiationResultDto(UUID paymentId) {
    this.paymentId = paymentId;
  }

  public PaymentInitiationResultDto paymentId(UUID paymentId) {
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

  public PaymentInitiationResultDto paymentUrl(URI paymentUrl) {
    this.paymentUrl = paymentUrl;
    return this;
  }

  /**
   * URL de pagamento gerada pelo gateway (ex: Mercado Pago). Será null em caso de falha no processamento.
   * @return paymentUrl
   */
  @Valid 
  @Schema(name = "paymentUrl", example = "https://www.mercadopago.com/mlb/payments/ticket?foo=bar", description = "URL de pagamento gerada pelo gateway (ex: Mercado Pago). Será null em caso de falha no processamento.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("paymentUrl")
  public URI getPaymentUrl() {
    return paymentUrl;
  }

  public void setPaymentUrl(URI paymentUrl) {
    this.paymentUrl = paymentUrl;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PaymentInitiationResultDto paymentInitiationResult = (PaymentInitiationResultDto) o;
    return Objects.equals(this.paymentId, paymentInitiationResult.paymentId) &&
        Objects.equals(this.paymentUrl, paymentInitiationResult.paymentUrl);
  }

  @Override
  public int hashCode() {
    return Objects.hash(paymentId, paymentUrl);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PaymentInitiationResultDto {\n");
    sb.append("    paymentId: ").append(toIndentedString(paymentId)).append("\n");
    sb.append("    paymentUrl: ").append(toIndentedString(paymentUrl)).append("\n");
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

    private PaymentInitiationResultDto instance;

    public Builder() {
      this(new PaymentInitiationResultDto());
    }

    protected Builder(PaymentInitiationResultDto instance) {
      this.instance = instance;
    }

    protected Builder copyOf(PaymentInitiationResultDto value) { 
      this.instance.setPaymentId(value.paymentId);
      this.instance.setPaymentUrl(value.paymentUrl);
      return this;
    }

    public PaymentInitiationResultDto.Builder paymentId(UUID paymentId) {
      this.instance.paymentId(paymentId);
      return this;
    }
    
    public PaymentInitiationResultDto.Builder paymentUrl(URI paymentUrl) {
      this.instance.paymentUrl(paymentUrl);
      return this;
    }
    
    /**
    * returns a built PaymentInitiationResultDto instance.
    *
    * The builder is not reusable (NullPointerException)
    */
    public PaymentInitiationResultDto build() {
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
  public static PaymentInitiationResultDto.Builder builder() {
    return new PaymentInitiationResultDto.Builder();
  }

  /**
  * Create a builder with a shallow copy of this instance.
  */
  public PaymentInitiationResultDto.Builder toBuilder() {
    PaymentInitiationResultDto.Builder builder = new PaymentInitiationResultDto.Builder();
    return builder.copyOf(this);
  }

}

