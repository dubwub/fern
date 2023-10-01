/**
 * This file was auto-generated by Fern from our API Definition.
 */

package resources.commons.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import core.ObjectMappers;
import java.lang.Boolean;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(
    builder = ListType.Builder.class
)
public final class ListType {
  private final VariableType valueType;

  private final Optional<Boolean> isFixedLength;

  private ListType(VariableType valueType, Optional<Boolean> isFixedLength) {
    this.valueType = valueType;
    this.isFixedLength = isFixedLength;
  }

  @JsonProperty("valueType")
  public VariableType getValueType() {
    return valueType;
  }

  /**
   * @return Whether this list is fixed-size (for languages that supports fixed-size lists). Defaults to false.
   */
  @JsonProperty("isFixedLength")
  public Optional<Boolean> getIsFixedLength() {
    return isFixedLength;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof ListType && equalTo((ListType) other);
  }

  private boolean equalTo(ListType other) {
    return valueType.equals(other.valueType) && isFixedLength.equals(other.isFixedLength);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.valueType, this.isFixedLength);
  }

  @Override
  public String toString() {
    return ObjectMappers.stringify(this);
  }

  public static ValueTypeStage builder() {
    return new Builder();
  }

  public interface ValueTypeStage {
    _FinalStage valueType(VariableType valueType);

    Builder from(ListType other);
  }

  public interface _FinalStage {
    ListType build();

    _FinalStage isFixedLength(Optional<Boolean> isFixedLength);

    _FinalStage isFixedLength(Boolean isFixedLength);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements ValueTypeStage, _FinalStage {
    private VariableType valueType;

    private Optional<Boolean> isFixedLength = Optional.empty();

    private Builder() {
    }

    @Override
    public Builder from(ListType other) {
      valueType(other.getValueType());
      isFixedLength(other.getIsFixedLength());
      return this;
    }

    @Override
    @JsonSetter("valueType")
    public _FinalStage valueType(VariableType valueType) {
      this.valueType = valueType;
      return this;
    }

    /**
     * <p>Whether this list is fixed-size (for languages that supports fixed-size lists). Defaults to false.</p>
     * @return Reference to {@code this} so that method calls can be chained together.
     */
    @Override
    public _FinalStage isFixedLength(Boolean isFixedLength) {
      this.isFixedLength = Optional.of(isFixedLength);
      return this;
    }

    @Override
    @JsonSetter(
        value = "isFixedLength",
        nulls = Nulls.SKIP
    )
    public _FinalStage isFixedLength(Optional<Boolean> isFixedLength) {
      this.isFixedLength = isFixedLength;
      return this;
    }

    @Override
    public ListType build() {
      return new ListType(valueType, isFixedLength);
    }
  }
}
