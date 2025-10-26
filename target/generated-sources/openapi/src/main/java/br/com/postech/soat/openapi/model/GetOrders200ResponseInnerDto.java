package br.com.postech.soat.openapi.model;

import java.net.URI;
import java.util.Objects;
import br.com.postech.soat.openapi.model.OrderItemDto;
import br.com.postech.soat.openapi.model.OrderStatusDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonValue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import org.springframework.lang.Nullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * GetOrders200ResponseInnerDto
 */

@JsonTypeName("get_orders_200_response_inner")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.12.0")
public class GetOrders200ResponseInnerDto {

  private UUID orderId;

  private UUID customerId;

  @Valid
  private List<@Valid OrderItemDto> items = new ArrayList<>();

  private Double discountAmountTotal;

  private Double total;

  private OrderStatusDto status;

  public GetOrders200ResponseInnerDto() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public GetOrders200ResponseInnerDto(UUID orderId, UUID customerId, List<@Valid OrderItemDto> items, Double discountAmountTotal, Double total, OrderStatusDto status) {
    this.orderId = orderId;
    this.customerId = customerId;
    this.items = items;
    this.discountAmountTotal = discountAmountTotal;
    this.total = total;
    this.status = status;
  }

  public GetOrders200ResponseInnerDto orderId(UUID orderId) {
    this.orderId = orderId;
    return this;
  }

  /**
   * Identificador único universal no formato UUID.
   * @return orderId
   */
  @NotNull @Valid 
  @Schema(name = "OrderId", example = "241fae7b-0210-4d29-a928-90653c9a9a89", description = "Identificador único universal no formato UUID.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("OrderId")
  public UUID getOrderId() {
    return orderId;
  }

  public void setOrderId(UUID orderId) {
    this.orderId = orderId;
  }

  public GetOrders200ResponseInnerDto customerId(UUID customerId) {
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

  public GetOrders200ResponseInnerDto items(List<@Valid OrderItemDto> items) {
    this.items = items;
    return this;
  }

  public GetOrders200ResponseInnerDto addItemsItem(OrderItemDto itemsItem) {
    if (this.items == null) {
      this.items = new ArrayList<>();
    }
    this.items.add(itemsItem);
    return this;
  }

  /**
   * Get items
   * @return items
   */
  @NotNull @Valid 
  @Schema(name = "items", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("items")
  public List<@Valid OrderItemDto> getItems() {
    return items;
  }

  public void setItems(List<@Valid OrderItemDto> items) {
    this.items = items;
  }

  public GetOrders200ResponseInnerDto discountAmountTotal(Double discountAmountTotal) {
    this.discountAmountTotal = discountAmountTotal;
    return this;
  }

  /**
   * Valor monetário representado em formato brasileiro (R$), com suporte a casas decimais.
   * @return discountAmountTotal
   */
  @NotNull 
  @Schema(name = "discountAmountTotal", example = "1946.32", description = "Valor monetário representado em formato brasileiro (R$), com suporte a casas decimais.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("discountAmountTotal")
  public Double getDiscountAmountTotal() {
    return discountAmountTotal;
  }

  public void setDiscountAmountTotal(Double discountAmountTotal) {
    this.discountAmountTotal = discountAmountTotal;
  }

  public GetOrders200ResponseInnerDto total(Double total) {
    this.total = total;
    return this;
  }

  /**
   * Valor monetário representado em formato brasileiro (R$), com suporte a casas decimais.
   * @return total
   */
  @NotNull 
  @Schema(name = "total", example = "1946.32", description = "Valor monetário representado em formato brasileiro (R$), com suporte a casas decimais.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("total")
  public Double getTotal() {
    return total;
  }

  public void setTotal(Double total) {
    this.total = total;
  }

  public GetOrders200ResponseInnerDto status(OrderStatusDto status) {
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
  public OrderStatusDto getStatus() {
    return status;
  }

  public void setStatus(OrderStatusDto status) {
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
    GetOrders200ResponseInnerDto getOrders200ResponseInner = (GetOrders200ResponseInnerDto) o;
    return Objects.equals(this.orderId, getOrders200ResponseInner.orderId) &&
        Objects.equals(this.customerId, getOrders200ResponseInner.customerId) &&
        Objects.equals(this.items, getOrders200ResponseInner.items) &&
        Objects.equals(this.discountAmountTotal, getOrders200ResponseInner.discountAmountTotal) &&
        Objects.equals(this.total, getOrders200ResponseInner.total) &&
        Objects.equals(this.status, getOrders200ResponseInner.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(orderId, customerId, items, discountAmountTotal, total, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetOrders200ResponseInnerDto {\n");
    sb.append("    orderId: ").append(toIndentedString(orderId)).append("\n");
    sb.append("    customerId: ").append(toIndentedString(customerId)).append("\n");
    sb.append("    items: ").append(toIndentedString(items)).append("\n");
    sb.append("    discountAmountTotal: ").append(toIndentedString(discountAmountTotal)).append("\n");
    sb.append("    total: ").append(toIndentedString(total)).append("\n");
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

    private GetOrders200ResponseInnerDto instance;

    public Builder() {
      this(new GetOrders200ResponseInnerDto());
    }

    protected Builder(GetOrders200ResponseInnerDto instance) {
      this.instance = instance;
    }

    protected Builder copyOf(GetOrders200ResponseInnerDto value) { 
      this.instance.setOrderId(value.orderId);
      this.instance.setCustomerId(value.customerId);
      this.instance.setItems(value.items);
      this.instance.setDiscountAmountTotal(value.discountAmountTotal);
      this.instance.setTotal(value.total);
      this.instance.setStatus(value.status);
      return this;
    }

    public GetOrders200ResponseInnerDto.Builder orderId(UUID orderId) {
      this.instance.orderId(orderId);
      return this;
    }
    
    public GetOrders200ResponseInnerDto.Builder customerId(UUID customerId) {
      this.instance.customerId(customerId);
      return this;
    }
    
    public GetOrders200ResponseInnerDto.Builder items(List<OrderItemDto> items) {
      this.instance.items(items);
      return this;
    }
    
    public GetOrders200ResponseInnerDto.Builder discountAmountTotal(Double discountAmountTotal) {
      this.instance.discountAmountTotal(discountAmountTotal);
      return this;
    }
    
    public GetOrders200ResponseInnerDto.Builder total(Double total) {
      this.instance.total(total);
      return this;
    }
    
    public GetOrders200ResponseInnerDto.Builder status(OrderStatusDto status) {
      this.instance.status(status);
      return this;
    }
    
    /**
    * returns a built GetOrders200ResponseInnerDto instance.
    *
    * The builder is not reusable (NullPointerException)
    */
    public GetOrders200ResponseInnerDto build() {
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
  public static GetOrders200ResponseInnerDto.Builder builder() {
    return new GetOrders200ResponseInnerDto.Builder();
  }

  /**
  * Create a builder with a shallow copy of this instance.
  */
  public GetOrders200ResponseInnerDto.Builder toBuilder() {
    GetOrders200ResponseInnerDto.Builder builder = new GetOrders200ResponseInnerDto.Builder();
    return builder.copyOf(this);
  }

}

