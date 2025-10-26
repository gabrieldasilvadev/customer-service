package br.com.postech.soat.openapi.model;

import java.net.URI;
import java.util.Objects;
import br.com.postech.soat.openapi.model.OrderItemDto;
import br.com.postech.soat.openapi.model.OrderStatusDto;
import br.com.postech.soat.openapi.model.PostOrders201ResponseDiscountsInnerDto;
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
 * PostOrders201ResponseDto
 */

@JsonTypeName("post_orders_201_response")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.12.0")
public class PostOrders201ResponseDto {

  private UUID orderId;

  @Valid
  private List<@Valid OrderItemDto> items = new ArrayList<>();

  @Valid
  private List<@Valid PostOrders201ResponseDiscountsInnerDto> discounts = new ArrayList<>();

  private Double discountAmountTotal;

  private Double subtotal;

  private Double total;

  private OrderStatusDto status;

  public PostOrders201ResponseDto() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public PostOrders201ResponseDto(UUID orderId, List<@Valid OrderItemDto> items, Double discountAmountTotal, Double subtotal, Double total, OrderStatusDto status) {
    this.orderId = orderId;
    this.items = items;
    this.discountAmountTotal = discountAmountTotal;
    this.subtotal = subtotal;
    this.total = total;
    this.status = status;
  }

  public PostOrders201ResponseDto orderId(UUID orderId) {
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

  public PostOrders201ResponseDto items(List<@Valid OrderItemDto> items) {
    this.items = items;
    return this;
  }

  public PostOrders201ResponseDto addItemsItem(OrderItemDto itemsItem) {
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
  @Valid 
  @Schema(name = "items", accessMode = Schema.AccessMode.READ_ONLY, requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("items")
  public List<@Valid OrderItemDto> getItems() {
    return items;
  }

  public void setItems(List<@Valid OrderItemDto> items) {
    this.items = items;
  }

  public PostOrders201ResponseDto discounts(List<@Valid PostOrders201ResponseDiscountsInnerDto> discounts) {
    this.discounts = discounts;
    return this;
  }

  public PostOrders201ResponseDto addDiscountsItem(PostOrders201ResponseDiscountsInnerDto discountsItem) {
    if (this.discounts == null) {
      this.discounts = new ArrayList<>();
    }
    this.discounts.add(discountsItem);
    return this;
  }

  /**
   * Get discounts
   * @return discounts
   */
  @Valid 
  @Schema(name = "discounts", accessMode = Schema.AccessMode.READ_ONLY, requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("discounts")
  public List<@Valid PostOrders201ResponseDiscountsInnerDto> getDiscounts() {
    return discounts;
  }

  public void setDiscounts(List<@Valid PostOrders201ResponseDiscountsInnerDto> discounts) {
    this.discounts = discounts;
  }

  public PostOrders201ResponseDto discountAmountTotal(Double discountAmountTotal) {
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

  public PostOrders201ResponseDto subtotal(Double subtotal) {
    this.subtotal = subtotal;
    return this;
  }

  /**
   * Valor monetário representado em formato brasileiro (R$), com suporte a casas decimais.
   * @return subtotal
   */
  @NotNull 
  @Schema(name = "subtotal", example = "1946.32", description = "Valor monetário representado em formato brasileiro (R$), com suporte a casas decimais.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("subtotal")
  public Double getSubtotal() {
    return subtotal;
  }

  public void setSubtotal(Double subtotal) {
    this.subtotal = subtotal;
  }

  public PostOrders201ResponseDto total(Double total) {
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

  public PostOrders201ResponseDto status(OrderStatusDto status) {
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
    PostOrders201ResponseDto postOrders201Response = (PostOrders201ResponseDto) o;
    return Objects.equals(this.orderId, postOrders201Response.orderId) &&
        Objects.equals(this.items, postOrders201Response.items) &&
        Objects.equals(this.discounts, postOrders201Response.discounts) &&
        Objects.equals(this.discountAmountTotal, postOrders201Response.discountAmountTotal) &&
        Objects.equals(this.subtotal, postOrders201Response.subtotal) &&
        Objects.equals(this.total, postOrders201Response.total) &&
        Objects.equals(this.status, postOrders201Response.status);
  }

  @Override
  public int hashCode() {
    return Objects.hash(orderId, items, discounts, discountAmountTotal, subtotal, total, status);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PostOrders201ResponseDto {\n");
    sb.append("    orderId: ").append(toIndentedString(orderId)).append("\n");
    sb.append("    items: ").append(toIndentedString(items)).append("\n");
    sb.append("    discounts: ").append(toIndentedString(discounts)).append("\n");
    sb.append("    discountAmountTotal: ").append(toIndentedString(discountAmountTotal)).append("\n");
    sb.append("    subtotal: ").append(toIndentedString(subtotal)).append("\n");
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

    private PostOrders201ResponseDto instance;

    public Builder() {
      this(new PostOrders201ResponseDto());
    }

    protected Builder(PostOrders201ResponseDto instance) {
      this.instance = instance;
    }

    protected Builder copyOf(PostOrders201ResponseDto value) { 
      this.instance.setOrderId(value.orderId);
      this.instance.setItems(value.items);
      this.instance.setDiscounts(value.discounts);
      this.instance.setDiscountAmountTotal(value.discountAmountTotal);
      this.instance.setSubtotal(value.subtotal);
      this.instance.setTotal(value.total);
      this.instance.setStatus(value.status);
      return this;
    }

    public PostOrders201ResponseDto.Builder orderId(UUID orderId) {
      this.instance.orderId(orderId);
      return this;
    }
    
    public PostOrders201ResponseDto.Builder items(List<OrderItemDto> items) {
      this.instance.items(items);
      return this;
    }
    
    public PostOrders201ResponseDto.Builder discounts(List<PostOrders201ResponseDiscountsInnerDto> discounts) {
      this.instance.discounts(discounts);
      return this;
    }
    
    public PostOrders201ResponseDto.Builder discountAmountTotal(Double discountAmountTotal) {
      this.instance.discountAmountTotal(discountAmountTotal);
      return this;
    }
    
    public PostOrders201ResponseDto.Builder subtotal(Double subtotal) {
      this.instance.subtotal(subtotal);
      return this;
    }
    
    public PostOrders201ResponseDto.Builder total(Double total) {
      this.instance.total(total);
      return this;
    }
    
    public PostOrders201ResponseDto.Builder status(OrderStatusDto status) {
      this.instance.status(status);
      return this;
    }
    
    /**
    * returns a built PostOrders201ResponseDto instance.
    *
    * The builder is not reusable (NullPointerException)
    */
    public PostOrders201ResponseDto build() {
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
  public static PostOrders201ResponseDto.Builder builder() {
    return new PostOrders201ResponseDto.Builder();
  }

  /**
  * Create a builder with a shallow copy of this instance.
  */
  public PostOrders201ResponseDto.Builder toBuilder() {
    PostOrders201ResponseDto.Builder builder = new PostOrders201ResponseDto.Builder();
    return builder.copyOf(this);
  }

}

