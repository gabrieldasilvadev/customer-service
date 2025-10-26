package br.com.postech.soat.openapi.model;

import java.net.URI;
import java.util.Objects;
import br.com.postech.soat.openapi.model.CategoryDto;
import br.com.postech.soat.openapi.model.DiscountDto;
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
 * Item individual de um pedido, contendo todas as informações do produto e quantidade solicitada.
 */

@Schema(name = "OrderItem", description = "Item individual de um pedido, contendo todas as informações do produto e quantidade solicitada.")
@JsonTypeName("OrderItem")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.12.0")
public class OrderItemDto {

  private UUID productId;

  private String name;

  private Integer quantity;

  private Double price;

  private CategoryDto category;

  private @Nullable DiscountDto discount;

  public OrderItemDto() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public OrderItemDto(UUID productId, String name, Integer quantity, Double price, CategoryDto category) {
    this.productId = productId;
    this.name = name;
    this.quantity = quantity;
    this.price = price;
    this.category = category;
  }

  public OrderItemDto productId(UUID productId) {
    this.productId = productId;
    return this;
  }

  /**
   * Identificador único universal no formato UUID.
   * @return productId
   */
  @NotNull @Valid 
  @Schema(name = "productId", example = "241fae7b-0210-4d29-a928-90653c9a9a89", description = "Identificador único universal no formato UUID.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("productId")
  public UUID getProductId() {
    return productId;
  }

  public void setProductId(UUID productId) {
    this.productId = productId;
  }

  public OrderItemDto name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Nome do produto
   * @return name
   */
  @NotNull 
  @Schema(name = "name", example = "Big Mac", description = "Nome do produto", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public OrderItemDto quantity(Integer quantity) {
    this.quantity = quantity;
    return this;
  }

  /**
   * Quantidade solicitada do produto
   * minimum: 1
   * maximum: 100
   * @return quantity
   */
  @NotNull @Min(1) @Max(100) 
  @Schema(name = "quantity", example = "2", description = "Quantidade solicitada do produto", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("quantity")
  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }

  public OrderItemDto price(Double price) {
    this.price = price;
    return this;
  }

  /**
   * Valor monetário representado em formato brasileiro (R$), com suporte a casas decimais.
   * @return price
   */
  @NotNull 
  @Schema(name = "price", example = "1946.32", description = "Valor monetário representado em formato brasileiro (R$), com suporte a casas decimais.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("price")
  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public OrderItemDto category(CategoryDto category) {
    this.category = category;
    return this;
  }

  /**
   * Get category
   * @return category
   */
  @NotNull @Valid 
  @Schema(name = "category", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("category")
  public CategoryDto getCategory() {
    return category;
  }

  public void setCategory(CategoryDto category) {
    this.category = category;
  }

  public OrderItemDto discount(DiscountDto discount) {
    this.discount = discount;
    return this;
  }

  /**
   * Get discount
   * @return discount
   */
  @Valid 
  @Schema(name = "discount", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("discount")
  public DiscountDto getDiscount() {
    return discount;
  }

  public void setDiscount(DiscountDto discount) {
    this.discount = discount;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    OrderItemDto orderItem = (OrderItemDto) o;
    return Objects.equals(this.productId, orderItem.productId) &&
        Objects.equals(this.name, orderItem.name) &&
        Objects.equals(this.quantity, orderItem.quantity) &&
        Objects.equals(this.price, orderItem.price) &&
        Objects.equals(this.category, orderItem.category) &&
        Objects.equals(this.discount, orderItem.discount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(productId, name, quantity, price, category, discount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class OrderItemDto {\n");
    sb.append("    productId: ").append(toIndentedString(productId)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
    sb.append("    discount: ").append(toIndentedString(discount)).append("\n");
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

    private OrderItemDto instance;

    public Builder() {
      this(new OrderItemDto());
    }

    protected Builder(OrderItemDto instance) {
      this.instance = instance;
    }

    protected Builder copyOf(OrderItemDto value) { 
      this.instance.setProductId(value.productId);
      this.instance.setName(value.name);
      this.instance.setQuantity(value.quantity);
      this.instance.setPrice(value.price);
      this.instance.setCategory(value.category);
      this.instance.setDiscount(value.discount);
      return this;
    }

    public OrderItemDto.Builder productId(UUID productId) {
      this.instance.productId(productId);
      return this;
    }
    
    public OrderItemDto.Builder name(String name) {
      this.instance.name(name);
      return this;
    }
    
    public OrderItemDto.Builder quantity(Integer quantity) {
      this.instance.quantity(quantity);
      return this;
    }
    
    public OrderItemDto.Builder price(Double price) {
      this.instance.price(price);
      return this;
    }
    
    public OrderItemDto.Builder category(CategoryDto category) {
      this.instance.category(category);
      return this;
    }
    
    public OrderItemDto.Builder discount(DiscountDto discount) {
      this.instance.discount(discount);
      return this;
    }
    
    /**
    * returns a built OrderItemDto instance.
    *
    * The builder is not reusable (NullPointerException)
    */
    public OrderItemDto build() {
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
  public static OrderItemDto.Builder builder() {
    return new OrderItemDto.Builder();
  }

  /**
  * Create a builder with a shallow copy of this instance.
  */
  public OrderItemDto.Builder toBuilder() {
    OrderItemDto.Builder builder = new OrderItemDto.Builder();
    return builder.copyOf(this);
  }

}

