package br.com.postech.soat.openapi.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.springframework.lang.Nullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * PostProducts201ResponseDto
 */

@JsonTypeName("postProducts_201_response")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", comments = "Generator version: 7.12.0")
public class PostProducts201ResponseDto {

  private @Nullable String id;

  public PostProducts201ResponseDto id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   */
  
  @Schema(name = "id", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("id")
  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PostProducts201ResponseDto postProducts201Response = (PostProducts201ResponseDto) o;
    return Objects.equals(this.id, postProducts201Response.id);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PostProducts201ResponseDto {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
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

    private PostProducts201ResponseDto instance;

    public Builder() {
      this(new PostProducts201ResponseDto());
    }

    protected Builder(PostProducts201ResponseDto instance) {
      this.instance = instance;
    }

    protected Builder copyOf(PostProducts201ResponseDto value) { 
      this.instance.setId(value.id);
      return this;
    }

    public PostProducts201ResponseDto.Builder id(String id) {
      this.instance.id(id);
      return this;
    }
    
    /**
    * returns a built PostProducts201ResponseDto instance.
    *
    * The builder is not reusable (NullPointerException)
    */
    public PostProducts201ResponseDto build() {
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
  public static PostProducts201ResponseDto.Builder builder() {
    return new PostProducts201ResponseDto.Builder();
  }

  /**
  * Create a builder with a shallow copy of this instance.
  */
  public PostProducts201ResponseDto.Builder toBuilder() {
    PostProducts201ResponseDto.Builder builder = new PostProducts201ResponseDto.Builder();
    return builder.copyOf(this);
  }

}

