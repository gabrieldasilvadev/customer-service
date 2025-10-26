package br.com.postech.soat.openapi.model;

import java.net.URI;
import java.util.Objects;
import br.com.postech.soat.openapi.model.PaymentStatusDto;
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
 * GetPaymentsPaymentIdStatus200ResponseDto
 */

@JsonTypeName("get_payments_paymentId_status_200_response")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.12.0")
public class GetPaymentsPaymentIdStatus200ResponseDto {

  private UUID paymentId;

  private PaymentStatusDto status;

  public GetPaymentsPaymentIdStatus200ResponseDto() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public GetPaymentsPaymentIdStatus200ResponseDto(UUID paymentId, PaymentStatusDto status) {
    this.paymentId = paymentId;
    this.status = status;
  }

  public GetPaymentsPaymentIdStatus200ResponseDto paymentId(UUID paymentId) {
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

  public GetPaymentsPaymentIdStatus200ResponseDto status(PaymentStatusDto status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
   */
  @NotNull @Valid 
  @Schema(name = "status", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("status")
  public PaymentStatusDto getStatus() {
    return status;
  }

  public void setStatus(PaymentStatusDto status) {
    this.status = status;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetPaymentsPaymentIdStatus200ResponseDto getPaymentsPaymentIdStatus200Response = (GetPaymentsPaymentIdStatus200ResponseDto) o;
    return Objects.equals(this.paymentId, getPaymentsPaymentIdStatus200Response.paymentId) &&
        Objects.equals(this.status, getPaymentsPaymentIdStatus200Response.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(paymentId, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetPaymentsPaymentIdStatus200ResponseDto {\n");
    sb.append("    paymentId: ").append(toIndentedString(paymentId)).append("\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
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

    private GetPaymentsPaymentIdStatus200ResponseDto instance;

    public Builder() {
      this(new GetPaymentsPaymentIdStatus200ResponseDto());
    }

    protected Builder(GetPaymentsPaymentIdStatus200ResponseDto instance) {
      this.instance = instance;
    }

    protected Builder copyOf(GetPaymentsPaymentIdStatus200ResponseDto value) { 
      this.instance.setPaymentId(value.paymentId);
      this.instance.setStatus(value.status);
      return this;
    }

    public GetPaymentsPaymentIdStatus200ResponseDto.Builder paymentId(UUID paymentId) {
      this.instance.paymentId(paymentId);
      return this;
    }
    
    public GetPaymentsPaymentIdStatus200ResponseDto.Builder status(PaymentStatusDto status) {
      this.instance.status(status);
      return this;
    }
    
    /**
    * returns a built GetPaymentsPaymentIdStatus200ResponseDto instance.
    *
    * The builder is not reusable (NullPointerException)
    */
    public GetPaymentsPaymentIdStatus200ResponseDto build() {
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
  public static GetPaymentsPaymentIdStatus200ResponseDto.Builder builder() {
    return new GetPaymentsPaymentIdStatus200ResponseDto.Builder();
  }

  /**
  * Create a builder with a shallow copy of this instance.
  */
  public GetPaymentsPaymentIdStatus200ResponseDto.Builder toBuilder() {
    GetPaymentsPaymentIdStatus200ResponseDto.Builder builder = new GetPaymentsPaymentIdStatus200ResponseDto.Builder();
    return builder.copyOf(this);
  }

}

