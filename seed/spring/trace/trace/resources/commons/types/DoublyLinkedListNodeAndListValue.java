/**
 * This file was auto-generated by Fern from our API Definition.
 */

package resources.commons.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import core.ObjectMappers;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(
    builder = DoublyLinkedListNodeAndListValue.Builder.class
)
public final class DoublyLinkedListNodeAndListValue {
  private final NodeId nodeId;

  private final DoublyLinkedListValue fullList;

  private DoublyLinkedListNodeAndListValue(NodeId nodeId, DoublyLinkedListValue fullList) {
    this.nodeId = nodeId;
    this.fullList = fullList;
  }

  @JsonProperty("nodeId")
  public NodeId getNodeId() {
    return nodeId;
  }

  @JsonProperty("fullList")
  public DoublyLinkedListValue getFullList() {
    return fullList;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof DoublyLinkedListNodeAndListValue && equalTo((DoublyLinkedListNodeAndListValue) other);
  }

  private boolean equalTo(DoublyLinkedListNodeAndListValue other) {
    return nodeId.equals(other.nodeId) && fullList.equals(other.fullList);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.nodeId, this.fullList);
  }

  @Override
  public String toString() {
    return ObjectMappers.stringify(this);
  }

  public static NodeIdStage builder() {
    return new Builder();
  }

  public interface NodeIdStage {
    FullListStage nodeId(NodeId nodeId);

    Builder from(DoublyLinkedListNodeAndListValue other);
  }

  public interface FullListStage {
    _FinalStage fullList(DoublyLinkedListValue fullList);
  }

  public interface _FinalStage {
    DoublyLinkedListNodeAndListValue build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements NodeIdStage, FullListStage, _FinalStage {
    private NodeId nodeId;

    private DoublyLinkedListValue fullList;

    private Builder() {
    }

    @Override
    public Builder from(DoublyLinkedListNodeAndListValue other) {
      nodeId(other.getNodeId());
      fullList(other.getFullList());
      return this;
    }

    @Override
    @JsonSetter("nodeId")
    public FullListStage nodeId(NodeId nodeId) {
      this.nodeId = nodeId;
      return this;
    }

    @Override
    @JsonSetter("fullList")
    public _FinalStage fullList(DoublyLinkedListValue fullList) {
      this.fullList = fullList;
      return this;
    }

    @Override
    public DoublyLinkedListNodeAndListValue build() {
      return new DoublyLinkedListNodeAndListValue(nodeId, fullList);
    }
  }
}
