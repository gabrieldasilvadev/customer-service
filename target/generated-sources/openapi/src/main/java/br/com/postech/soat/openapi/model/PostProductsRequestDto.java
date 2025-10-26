package br.com.postech.soat.openapi.model;

import java.net.URI;
import java.util.Objects;
import br.com.postech.soat.openapi.model.ProductCategoryDto;
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
 * PostProductsRequestDto
 */

@JsonTypeName("postProducts_request")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.12.0")
public class PostProductsRequestDto {

  private String sku;

  private String name;

  private Double price;

  private String description;

  private String image;

  private ProductCategoryDto category;

  public PostProductsRequestDto() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public PostProductsRequestDto(String sku, String name, Double price, String description, String image, ProductCategoryDto category) {
    this.sku = sku;
    this.name = name;
    this.price = price;
    this.description = description;
    this.image = image;
    this.category = category;
  }

  public PostProductsRequestDto sku(String sku) {
    this.sku = sku;
    return this;
  }

  /**
   * Get sku
   * @return sku
   */
  @NotNull 
  @Schema(name = "sku", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("sku")
  public String getSku() {
    return sku;
  }

  public void setSku(String sku) {
    this.sku = sku;
  }

  public PostProductsRequestDto name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
   */
  @NotNull 
  @Schema(name = "name", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("name")
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public PostProductsRequestDto price(Double price) {
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

  public PostProductsRequestDto description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Get description
   * @return description
   */
  @NotNull 
  @Schema(name = "description", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("description")
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public PostProductsRequestDto image(String image) {
    this.image = image;
    return this;
  }

  /**
   * Get image
   * @return image
   */
  @NotNull 
  @Schema(name = "image", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("image")
  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public PostProductsRequestDto category(ProductCategoryDto category) {
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
    PostProductsRequestDto postProductsRequest = (PostProductsRequestDto) o;
    return Objects.equals(this.sku, postProductsRequest.sku) &&
        Objects.equals(this.name, postProductsRequest.name) &&
        Objects.equals(this.price, postProductsRequest.price) &&
        Objects.equals(this.description, postProductsRequest.description) &&
        Objects.equals(this.image, postProductsRequest.image) &&
        Objects.equals(this.category, postProductsRequest.category);
  }

  @Override
  public int hashCode() {
    return Objects.hash(sku, name, price, description, image, category);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PostProductsRequestDto {\n");
    sb.append("    sku: ").append(toIndentedString(sku)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    price: ").append(toIndentedString(price)).append("\n");
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
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

    private PostProductsRequestDto instance;

    public Builder() {
      this(new PostProductsRequestDto());
    }

    protected Builder(PostProductsRequestDto instance) {
      this.instance = instance;
    }

    protected Builder copyOf(PostProductsRequestDto value) { 
      this.instance.setSku(value.sku);
      this.instance.setName(value.name);
      this.instance.setPrice(value.price);
      this.instance.setDescription(value.description);
      this.instance.setImage(value.image);
      this.instance.setCategory(value.category);
      return this;
    }

    public PostProductsRequestDto.Builder sku(String sku) {
      this.instance.sku(sku);
      return this;
    }
    
    public PostProductsRequestDto.Builder name(String name) {
      this.instance.name(name);
      return this;
    }
    
    public PostProductsRequestDto.Builder price(Double price) {
      this.instance.price(price);
      return this;
    }
    
    public PostProductsRequestDto.Builder description(String description) {
      this.instance.description(description);
      return this;
    }
    
    public PostProductsRequestDto.Builder image(String image) {
      this.instance.image(image);
      return this;
    }
    
    public PostProductsRequestDto.Builder category(ProductCategoryDto category) {
      this.instance.category(category);
      return this;
    }
    
    /**
    * returns a built PostProductsRequestDto instance.
    *
    * The builder is not reusable (NullPointerException)
    */
    public PostProductsRequestDto build() {
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
  public static PostProductsRequestDto.Builder builder() {
    return new PostProductsRequestDto.Builder();
  }

  /**
  * Create a builder with a shallow copy of this instance.
  */
  public PostProductsRequestDto.Builder toBuilder() {
    PostProductsRequestDto.Builder builder = new PostProductsRequestDto.Builder();
    return builder.copyOf(this);
  }

}

