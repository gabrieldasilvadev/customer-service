package br.com.postech.soat.openapi.model;

import java.net.URI;
import java.util.Objects;
import br.com.postech.soat.openapi.model.ProductCategoryDto;
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
 * GetProduct200ResponseInnerDto
 */

@JsonTypeName("getProduct_200_response_inner")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.12.0")
public class GetProduct200ResponseInnerDto {

  private @Nullable UUID id;

  private @Nullable String sku;

  private @Nullable String name;

  private @Nullable String description;

  private @Nullable Double price;

  private @Nullable Boolean active;

  private @Nullable String image;

  private @Nullable ProductCategoryDto category;

  public GetProduct200ResponseInnerDto id(UUID id) {
    this.id = id;
    return this;
  }

  /**
   * Identificador único universal no formato UUID.
   * @return id
   */
  @Valid 
  @Schema(name = "id", example = "241fae7b-0210-4d29-a928-90653c9a9a89", description = "Identificador único universal no formato UUID.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public UUID getId() {
    return id;
  }

  public void setId(UUID id) {
    this.id = id;
  }

  public GetProduct200ResponseInnerDto sku(String sku) {
    this.sku = sku;
    return this;
  }

  /**
   * Get sku
   * @return sku
   */
  
  @Schema(name = "sku", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("sku")
  public String getSku() {
    return sku;
  }

  public void setSku(String sku) {
    this.sku = sku;
  }

  public GetProduct200ResponseInnerDto name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
   */
  
  @Schema(name = "name", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public GetProduct200ResponseInnerDto description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
   */
  
  @Schema(name = "description", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("description")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public GetProduct200ResponseInnerDto price(Double price) {
    this.price = price;
    return this;
  }

  /**
   * Valor monetário representado em formato brasileiro (R$), com suporte a casas decimais.
   * @return price
   */
  
  @Schema(name = "price", example = "1946.32", description = "Valor monetário representado em formato brasileiro (R$), com suporte a casas decimais.", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("price")
  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public GetProduct200ResponseInnerDto active(Boolean active) {
    this.active = active;
    return this;
  }

  /**
   * Get active
   * @return active
   */
  
  @Schema(name = "active", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("active")
  public Boolean getActive() {
    return active;
  }

  public void setActive(Boolean active) {
    this.active = active;
  }

  public GetProduct200ResponseInnerDto image(String image) {
    this.image = image;
    return this;
  }

  /**
   * Get image
   * @return image
   */
  
  @Schema(name = "image", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("image")
  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public GetProduct200ResponseInnerDto category(ProductCategoryDto category) {
    this.category = category;
    return this;
  }

  /**
   * Get category
   * @return category
   */
  @Valid 
  @Schema(name = "category", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("category")
  public ProductCategoryDto getCategory() {
    return category;
  }

  public void setCategory(ProductCategoryDto category) {
    this.category = category;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GetProduct200ResponseInnerDto getProduct200ResponseInner = (GetProduct200ResponseInnerDto) o;
    return Objects.equals(this.id, getProduct200ResponseInner.id) &&
        Objects.equals(this.sku, getProduct200ResponseInner.sku) &&
        Objects.equals(this.name, getProduct200ResponseInner.name) &&
        Objects.equals(this.description, getProduct200ResponseInner.description) &&
        Objects.equals(this.price, getProduct200ResponseInner.price) &&
        Objects.equals(this.active, getProduct200ResponseInner.active) &&
        Objects.equals(this.image, getProduct200ResponseInner.image) &&
        Objects.equals(this.category, getProduct200ResponseInner.category);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, sku, name, description, price, active, image, category);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GetProduct200ResponseInnerDto {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    sku: ").append(toIndentedString(sku)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("    active: ").append(toIndentedString(active)).append("\n");
    sb.append("    image: ").append(toIndentedString(image)).append("\n");
    sb.append("    category: ").append(toIndentedString(category)).append("\n");
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

    private GetProduct200ResponseInnerDto instance;

    public Builder() {
      this(new GetProduct200ResponseInnerDto());
    }

    protected Builder(GetProduct200ResponseInnerDto instance) {
      this.instance = instance;
    }

    protected Builder copyOf(GetProduct200ResponseInnerDto value) { 
      this.instance.setId(value.id);
      this.instance.setSku(value.sku);
      this.instance.setName(value.name);
      this.instance.setDescription(value.description);
      this.instance.setPrice(value.price);
      this.instance.setActive(value.active);
      this.instance.setImage(value.image);
      this.instance.setCategory(value.category);
      return this;
    }

    public GetProduct200ResponseInnerDto.Builder id(UUID id) {
      this.instance.id(id);
      return this;
    }
    
    public GetProduct200ResponseInnerDto.Builder sku(String sku) {
      this.instance.sku(sku);
      return this;
    }
    
    public GetProduct200ResponseInnerDto.Builder name(String name) {
      this.instance.name(name);
      return this;
    }
    
    public GetProduct200ResponseInnerDto.Builder description(String description) {
      this.instance.description(description);
      return this;
    }
    
    public GetProduct200ResponseInnerDto.Builder price(Double price) {
      this.instance.price(price);
      return this;
    }
    
    public GetProduct200ResponseInnerDto.Builder active(Boolean active) {
      this.instance.active(active);
      return this;
    }
    
    public GetProduct200ResponseInnerDto.Builder image(String image) {
      this.instance.image(image);
      return this;
    }
    
    public GetProduct200ResponseInnerDto.Builder category(ProductCategoryDto category) {
      this.instance.category(category);
      return this;
    }
    
    /**
    * returns a built GetProduct200ResponseInnerDto instance.
    *
    * The builder is not reusable (NullPointerException)
    */
    public GetProduct200ResponseInnerDto build() {
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
  public static GetProduct200ResponseInnerDto.Builder builder() {
    return new GetProduct200ResponseInnerDto.Builder();
  }

  /**
  * Create a builder with a shallow copy of this instance.
  */
  public GetProduct200ResponseInnerDto.Builder toBuilder() {
    GetProduct200ResponseInnerDto.Builder builder = new GetProduct200ResponseInnerDto.Builder();
    return builder.copyOf(this);
  }

}

