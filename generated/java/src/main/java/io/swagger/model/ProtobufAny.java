package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

    
    
    
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaArmeriaCodegen", date = "2021-08-16T17:48:16.555+03:00")
public class ProtobufAny   {

  public ProtobufAny() {}

  @JsonProperty("typeUrl")
  private String typeUrl = null;

  @JsonProperty("value")
  private byte[] value = null;

  /**
   **/
  public ProtobufAny typeUrl(String typeUrl) {
    this.typeUrl = typeUrl;
    return this;
  }

  /**
   * Get typeUrl
   * @return typeUrl
  **/
  @ApiModelProperty(value = "")
  @JsonProperty("typeUrl")
  public String getTypeUrl() {
    return typeUrl;
  }
  public void setTypeUrl(String typeUrl) {
    this.typeUrl = typeUrl;
  }

  /**
   **/
  public ProtobufAny value(byte[] value) {
    this.value = value;
    return this;
  }

  /**
   * Get value
   * @return value
  **/
  @ApiModelProperty(value = "")
  @JsonProperty("value")
  public byte[] getValue() {
    return value;
  }
  public void setValue(byte[] value) {
    this.value = value;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ProtobufAny protobufAny = (ProtobufAny) o;
    return Objects.equals(typeUrl, protobufAny.typeUrl) &&
        Objects.equals(value, protobufAny.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(typeUrl, value);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ProtobufAny {\n");
    
    sb.append("    typeUrl: ").append(toIndentedString(typeUrl)).append("\n");
    sb.append("    value: ").append(toIndentedString(value)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

