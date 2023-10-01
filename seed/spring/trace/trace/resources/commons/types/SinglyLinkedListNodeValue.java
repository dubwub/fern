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
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(
    builder = SinglyLinkedListNodeValue.Builder.class
)
public final class SinglyLinkedListNodeValue {
  private final NodeId nodeId;

  private final double val;

  private final Optional<NodeId> next;

  private SinglyLinkedListNodeValue(NodeId nodeId, double val, Optional<NodeId> next) {
    this.nodeId = nodeId;
    this.val = val;
    this.next = next;
  }

  @JsonProperty("nodeId")
  public NodeId getNodeId() {
    return nodeId;
  }

  @JsonProperty("val")
  public double getVal() {
    return val;
  }

  @JsonProperty("next")
  public Optional<NodeId> getNext() {
    return next;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof SinglyLinkedListNodeValue && equalTo((SinglyLinkedListNodeValue) other);
  }

  private boolean equalTo(SinglyLinkedListNodeValue other) {
    return nodeId.equals(other.nodeId) && val == other.val && next.equals(other.next);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.nodeId, this.val, this.next);
  }

  @Override
  public String toString() {
    return ObjectMappers.stringify(this);
  }

  public static NodeIdStage builder() {
    return new Builder();
  }

  public interface NodeIdStage {
    ValStage nodeId(NodeId nodeId);

    Builder from(SinglyLinkedListNodeValue other);
  }

  public interface ValStage {
    _FinalStage val(double val);
  }

  public interface _FinalStage {
    SinglyLinkedListNodeValue build();

    _FinalStage next(Optional<NodeId> next);

    _FinalStage next(NodeId next);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements NodeIdStage, ValStage, _FinalStage {
    private NodeId nodeId;

    private double val;

    private Optional<NodeId> next = Optional.empty();

    private Builder() {
    }

    @Override
    public Builder from(SinglyLinkedListNodeValue other) {
      nodeId(other.getNodeId());
      val(other.getVal());
      next(other.getNext());
      return this;
    }

    @Override
    @JsonSetter("nodeId")
    public ValStage nodeId(NodeId nodeId) {
      this.nodeId = nodeId;
      return this;
    }

    @Override
    @JsonSetter("val")
    public _FinalStage val(double val) {
      this.val = val;
      return this;
    }

    @Override
    public _FinalStage next(NodeId next) {
      this.next = Optional.of(next);
      return this;
    }

    @Override
    @JsonSetter(
        value = "next",
        nulls = Nulls.SKIP
    )
    public _FinalStage next(Optional<NodeId> next) {
      this.next = next;
      return this;
    }

    @Override
    public SinglyLinkedListNodeValue build() {
      return new SinglyLinkedListNodeValue(nodeId, val, next);
    }
  }
}
