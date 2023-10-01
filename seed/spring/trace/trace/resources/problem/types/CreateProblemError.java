/**
 * This file was auto-generated by Fern from our API Definition.
 */

package resources.problem.types;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.annotation.JsonValue;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

public final class CreateProblemError {
  private final Value value;

  @JsonCreator(
      mode = JsonCreator.Mode.DELEGATING
  )
  private CreateProblemError(Value value) {
    this.value = value;
  }

  public <T> T visit(Visitor<T> visitor) {
    return value.visit(visitor);
  }

  public static CreateProblemError generic(GenericCreateProblemError value) {
    return new CreateProblemError(new GenericValue(value));
  }

  public boolean isGeneric() {
    return value instanceof GenericValue;
  }

  public boolean _isUnknown() {
    return value instanceof _UnknownValue;
  }

  public Optional<GenericCreateProblemError> getGeneric() {
    if (isGeneric()) {
      return Optional.of(((GenericValue) value).value);
    }
    return Optional.empty();
  }

  public Optional<Object> _getUnknown() {
    if (_isUnknown()) {
      return Optional.of(((_UnknownValue) value).value);
    }
    return Optional.empty();
  }

  @JsonValue
  private Value getValue() {
    return this.value;
  }

  public interface Visitor<T> {
    T visitGeneric(GenericCreateProblemError generic);

    T _visitUnknown(Object unknownType);
  }

  @JsonTypeInfo(
      use = JsonTypeInfo.Id.NAME,
      property = "_type",
      visible = true,
      defaultImpl = _UnknownValue.class
  )
  @JsonSubTypes(@JsonSubTypes.Type(GenericValue.class))
  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  private interface Value {
    <T> T visit(Visitor<T> visitor);
  }

  @JsonTypeName("generic")
  private static final class GenericValue implements Value {
    @JsonUnwrapped
    private GenericCreateProblemError value;

    @JsonCreator(
        mode = JsonCreator.Mode.PROPERTIES
    )
    private GenericValue() {
    }

    private GenericValue(GenericCreateProblemError value) {
      this.value = value;
    }

    @Override
    public <T> T visit(Visitor<T> visitor) {
      return visitor.visitGeneric(value);
    }

    @Override
    public boolean equals(Object other) {
      if (this == other) return true;
      return other instanceof GenericValue && equalTo((GenericValue) other);
    }

    private boolean equalTo(GenericValue other) {
      return value.equals(other.value);
    }

    @Override
    public int hashCode() {
      return Objects.hash(this.value);
    }

    @Override
    public String toString() {
      return "CreateProblemError{" + "value: " + value + "}";
    }
  }

  private static final class _UnknownValue implements Value {
    private String type;

    @JsonValue
    private Object value;

    @JsonCreator(
        mode = JsonCreator.Mode.PROPERTIES
    )
    private _UnknownValue(@JsonProperty("value") Object value) {
    }

    @Override
    public <T> T visit(Visitor<T> visitor) {
      return visitor._visitUnknown(value);
    }

    @Override
    public boolean equals(Object other) {
      if (this == other) return true;
      return other instanceof _UnknownValue && equalTo((_UnknownValue) other);
    }

    private boolean equalTo(_UnknownValue other) {
      return type.equals(other.type) && value.equals(other.value);
    }

    @Override
    public int hashCode() {
      return Objects.hash(this.type, this.value);
    }

    @Override
    public String toString() {
      return "CreateProblemError{" + "type: " + type + ", value: " + value + "}";
    }
  }
}
