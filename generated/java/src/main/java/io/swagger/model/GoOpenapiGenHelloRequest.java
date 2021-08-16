package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

    
        /**
        * The request message containing the user&#39;s name.
        **/
    
    @ApiModel(description = "The request message containing the user's name.")
@javax.annotation.Generated(value = "io.swagger.codegen.languages.JavaArmeriaCodegen", date = "2021-08-16T17:48:16.555+03:00")
public class GoOpenapiGenHelloRequest   {

  public GoOpenapiGenHelloRequest() {}

  @JsonProperty("name")
  private String name = null;

  /**
   **/
  public GoOpenapiGenHelloRequest name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Get name
   * @return name
  **/
  @ApiModelProperty(value = "")
  @JsonProperty("name")
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    GoOpenapiGenHelloRequest goOpenapiGenHelloRequest = (GoOpenapiGenHelloRequest) o;
    return Objects.equals(name, goOpenapiGenHelloRequest.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class GoOpenapiGenHelloRequest {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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

