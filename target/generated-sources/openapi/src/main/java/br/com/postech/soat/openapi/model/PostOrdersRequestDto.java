package br.com.postech.soat.openapi.model;

import java.net.URI;
import java.util.Objects;
import br.com.postech.soat.openapi.model.DiscountDto;
import br.com.postech.soat.openapi.model.OrderItemDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
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
 * PostOrdersRequestDto
 */

@JsonTypeName("post_orders_request")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.12.0")
public class PostOrdersRequestDto {

  private UUID customerId;

  @Valid
  private List<@Valid OrderItemDto> items = new ArrayList<>();

  @Valid
  private List<@Valid DiscountDto> discounts = new ArrayList<>();

  @Valid
  private List<String> notes = new ArrayList<>();

  public PostOrdersRequestDto() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public PostOrdersRequestDto(UUID customerId, List<@Valid OrderItemDto> items) {
    this.customerId = customerId;
    this.items = items;
  }

  public PostOrdersRequestDto customerId(UUID customerId) {
    this.customerId = customerId;
    return this;
  }

  /**
   * Identificador único universal no formato UUID.
   * @return customerId
   */
  @NotNull @Valid 
  @Schema(name = "CustomerId", example = "241fae7b-0210-4d29-a928-90653c9a9a89", description = "Identificador único universal no formato UUID.", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("CustomerId")
  public UUID getCustomerId() {
    return customerId;
  }

  public void setCustomerId(UUID customerId) {
    this.customerId = customerId;
  }

  public PostOrdersRequestDto items(List<@Valid OrderItemDto> items) {
    this.items = items;
    return this;
  }

  public PostOrdersRequestDto addItemsItem(OrderItemDto itemsItem) {
    if (this.items == null) {
      this.items = new ArrayList<>();
    }
    this.items.add(itemsItem);
    return this;
  }

  /**
   * Lista completa de itens do pedido com todos os dados necessários
   * @return items
   */
  @NotNull @Valid @Size(min = 1, max = 100) 
  @Schema(name = "items", description = "Lista completa de itens do pedido com todos os dados necessários", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("items")
  public List<@Valid OrderItemDto> getItems() {
    return items;
  }

  public void setItems(List<@Valid OrderItemDto> items) {
    this.items = items;
  }

  public PostOrdersRequestDto discounts(List<@Valid DiscountDto> discounts) {
    this.discounts = discounts;
    return this;
  }

  public PostOrdersRequestDto addDiscountsItem(DiscountDto discountsItem) {
    if (this.discounts == null) {
      this.discounts = new ArrayList<>();
    }
    this.discounts.add(discountsItem);
    return this;
  }

  /**
   * Lista de descontos aplicáveis ao pedido
   * @return discounts
   */
  @Valid 
  @Schema(name = "discounts", description = "Lista de descontos aplicáveis ao pedido", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("discounts")
  public List<@Valid DiscountDto> getDiscounts() {
    return discounts;
  }

  public void setDiscounts(List<@Valid DiscountDto> discounts) {
    this.discounts = discounts;
  }

  public PostOrdersRequestDto notes(List<String> notes) {
    this.notes = notes;
    return this;
  }

  public PostOrdersRequestDto addNotesItem(String notesItem) {
    if (this.notes == null) {
      this.notes = new ArrayList<>();
    }
    this.notes.add(notesItem);
    return this;
  }

  /**
   * Observações opcionais para o pedido (ex: retirar salada, sem cebola)
   * @return notes
   */
  
  @Schema(name = "notes", description = "Observações opcionais para o pedido (ex: retirar salada, sem cebola)", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("notes")
  public List<String> getNotes() {
    return notes;
  }

  public void setNotes(List<String> notes) {
    this.notes = notes;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PostOrdersRequestDto postOrdersRequest = (PostOrdersRequestDto) o;
    return Objects.equals(this.customerId, postOrdersRequest.customerId) &&
        Objects.equals(this.items, postOrdersRequest.items) &&
        Objects.equals(this.discounts, postOrdersRequest.discounts) &&
        Objects.equals(this.notes, postOrdersRequest.notes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(customerId, items, discounts, notes);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PostOrdersRequestDto {\n");
    sb.append("    customerId: ").append(toIndentedString(customerId)).append("\n");
    sb.append("    items: ").append(toIndentedString(items)).append("\n");
    sb.append("    discounts: ").append(toIndentedString(discounts)).append("\n");
    sb.append("    notes: ").append(toIndentedString(notes)).append("\n");
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

    private PostOrdersRequestDto instance;

    public Builder() {
      this(new PostOrdersRequestDto());
    }

    protected Builder(PostOrdersRequestDto instance) {
      this.instance = instance;
    }

    protected Builder copyOf(PostOrdersRequestDto value) { 
      this.instance.setCustomerId(value.customerId);
      this.instance.setItems(value.items);
      this.instance.setDiscounts(value.discounts);
      this.instance.setNotes(value.notes);
      return this;
    }

    public PostOrdersRequestDto.Builder customerId(UUID customerId) {
      this.instance.customerId(customerId);
      return this;
    }
    
    public PostOrdersRequestDto.Builder items(List<OrderItemDto> items) {
      this.instance.items(items);
      return this;
    }
    
    public PostOrdersRequestDto.Builder discounts(List<DiscountDto> discounts) {
      this.instance.discounts(discounts);
      return this;
    }
    
    public PostOrdersRequestDto.Builder notes(List<String> notes) {
      this.instance.notes(notes);
      return this;
    }
    
    /**
    * returns a built PostOrdersRequestDto instance.
    *
    * The builder is not reusable (NullPointerException)
    */
    public PostOrdersRequestDto build() {
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
  public static PostOrdersRequestDto.Builder builder() {
    return new PostOrdersRequestDto.Builder();
  }

  /**
  * Create a builder with a shallow copy of this instance.
  */
  public PostOrdersRequestDto.Builder toBuilder() {
    PostOrdersRequestDto.Builder builder = new PostOrdersRequestDto.Builder();
    return builder.copyOf(this);
  }

}

