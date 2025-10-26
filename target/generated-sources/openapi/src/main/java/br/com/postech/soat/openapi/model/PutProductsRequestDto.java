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
 * PutProductsRequestDto
 */

@JsonTypeName("putProducts_request")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.12.0")
public class PutProductsRequestDto {

  private @Nullable String name;

  private @Nullable Double price;

  private @Nullable String description;

  private @Nullable String image;

  private @Nullable ProductCategoryDto category;

  public PutProductsRequestDto name(String name) {
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

  public PutProductsRequestDto price(Double price) {
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

  public PutProductsRequestDto description(String description) {
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

  public PutProductsRequestDto image(String image) {
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

  public PutProductsRequestDto category(ProductCategoryDto category) {
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
    PutProductsRequestDto putProductsRequest = (PutProductsRequestDto) o;
    return Objects.equals(this.name, putProductsRequest.name) &&
        Objects.equals(this.price, putProductsRequest.price) &&
        Objects.equals(this.description, putProductsRequest.description) &&
        Objects.equals(this.image, putProductsRequest.image) &&
        Objects.equals(this.category, putProductsRequest.category);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, price, description, image, category);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PutProductsRequestDto {\n");
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

    private PutProductsRequestDto instance;

    public Builder() {
      this(new PutProductsRequestDto());
    }

    protected Builder(PutProductsRequestDto instance) {
      this.instance = instance;
    }

    protected Builder copyOf(PutProductsRequestDto value) { 
      this.instance.setName(value.name);
      this.instance.setPrice(value.price);
      this.instance.setDescription(value.description);
      this.instance.setImage(value.image);
      this.instance.setCategory(value.category);
      return this;
    }

    public PutProductsRequestDto.Builder name(String name) {
      this.instance.name(name);
      return this;
    }
    
    public PutProductsRequestDto.Builder price(Double price) {
      this.instance.price(price);
      return this;
    }
    
    public PutProductsRequestDto.Builder description(String description) {
      this.instance.description(description);
      return this;
    }
    
    public PutProductsRequestDto.Builder image(String image) {
      this.instance.image(image);
      return this;
    }
    
    public PutProductsRequestDto.Builder category(ProductCategoryDto category) {
      this.instance.category(category);
      return this;
    }
    
    /**
    * returns a built PutProductsRequestDto instance.
    *
    * The builder is not reusable (NullPointerException)
    */
    public PutProductsRequestDto build() {
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
  public static PutProductsRequestDto.Builder builder() {
    return new PutProductsRequestDto.Builder();
  }

  /**
  * Create a builder with a shallow copy of this instance.
  */
  public PutProductsRequestDto.Builder toBuilder() {
    PutProductsRequestDto.Builder builder = new PutProductsRequestDto.Builder();
    return builder.copyOf(this);
  }

}

