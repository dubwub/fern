/**
 * This file was auto-generated by Fern from our API Definition.
 */

package resources.v2.problem.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import core.ObjectMappers;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import resources.commons.types.VariableType;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(
    builder = NonVoidFunctionSignature.Builder.class
)
public final class NonVoidFunctionSignature {
  private final List<Parameter> parameters;

  private final VariableType returnType;

  private NonVoidFunctionSignature(List<Parameter> parameters, VariableType returnType) {
    this.parameters = parameters;
    this.returnType = returnType;
  }

  @JsonProperty("parameters")
  public List<Parameter> getParameters() {
    return parameters;
  }

  @JsonProperty("returnType")
  public VariableType getReturnType() {
    return returnType;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof NonVoidFunctionSignature && equalTo((NonVoidFunctionSignature) other);
  }

  private boolean equalTo(NonVoidFunctionSignature other) {
    return parameters.equals(other.parameters) && returnType.equals(other.returnType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.parameters, this.returnType);
  }

  @Override
  public String toString() {
    return ObjectMappers.stringify(this);
  }

  public static ReturnTypeStage builder() {
    return new Builder();
  }

  public interface ReturnTypeStage {
    _FinalStage returnType(VariableType returnType);

    Builder from(NonVoidFunctionSignature other);
  }

  public interface _FinalStage {
    NonVoidFunctionSignature build();

    _FinalStage parameters(List<Parameter> parameters);

    _FinalStage addParameters(Parameter parameters);

    _FinalStage addAllParameters(List<Parameter> parameters);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements ReturnTypeStage, _FinalStage {
    private VariableType returnType;

    private List<Parameter> parameters = new ArrayList<>();

    private Builder() {
    }

    @Override
    public Builder from(NonVoidFunctionSignature other) {
      parameters(other.getParameters());
      returnType(other.getReturnType());
      return this;
    }

    @Override
    @JsonSetter("returnType")
    public _FinalStage returnType(VariableType returnType) {
      this.returnType = returnType;
      return this;
    }

    @Override
    public _FinalStage addAllParameters(List<Parameter> parameters) {
      this.parameters.addAll(parameters);
      return this;
    }

    @Override
    public _FinalStage addParameters(Parameter parameters) {
      this.parameters.add(parameters);
      return this;
    }

    @Override
    @JsonSetter(
        value = "parameters",
        nulls = Nulls.SKIP
    )
    public _FinalStage parameters(List<Parameter> parameters) {
      this.parameters.clear();
      this.parameters.addAll(parameters);
      return this;
    }

    @Override
    public NonVoidFunctionSignature build() {
      return new NonVoidFunctionSignature(parameters, returnType);
    }
  }
}
