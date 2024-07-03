/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.seed.objectsWithImports.types;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.seed.objectsWithImports.core.ObjectMappers;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = Tree.Builder.class)
public final class Tree {
    private final Optional<List<Node>> nodes;

    private final Map<String, Object> additionalProperties;

    private Tree(Optional<List<Node>> nodes, Map<String, Object> additionalProperties) {
        this.nodes = nodes;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("nodes")
    public Optional<List<Node>> getNodes() {
        return nodes;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof Tree && equalTo((Tree) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(Tree other) {
        return nodes.equals(other.nodes);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.nodes);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static Builder builder() {
        return new Builder();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder {
        private Optional<List<Node>> nodes = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        public Builder from(Tree other) {
            nodes(other.getNodes());
            return this;
        }

        @JsonSetter(value = "nodes", nulls = Nulls.SKIP)
        public Builder nodes(Optional<List<Node>> nodes) {
            this.nodes = nodes;
            return this;
        }

        public Builder nodes(List<Node> nodes) {
            this.nodes = Optional.of(nodes);
            return this;
        }

        public Tree build() {
            return new Tree(nodes, additionalProperties);
        }
    }
}
