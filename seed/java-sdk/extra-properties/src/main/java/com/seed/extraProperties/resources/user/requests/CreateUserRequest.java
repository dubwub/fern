/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.seed.extraProperties.resources.user.requests;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.seed.extraProperties.core.ObjectMappers;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = CreateUserRequest.Builder.class)
public final class CreateUserRequest {
    private final String name;

    private final Map<String, Object> additionalProperties;

    private CreateUserRequest(String name, Map<String, Object> additionalProperties) {
        this.name = name;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("_type")
    public String getType() {
        return "CreateUserRequest";
    }

    @JsonProperty("_version")
    public String getVersion() {
        return "v1";
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof CreateUserRequest && equalTo((CreateUserRequest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(CreateUserRequest other) {
        return name.equals(other.name);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.name);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static NameStage builder() {
        return new Builder();
    }

    public interface NameStage {
        _FinalStage name(String name);

        Builder from(CreateUserRequest other);
    }

    public interface _FinalStage {
        CreateUserRequest build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements NameStage, _FinalStage {
        private String name;

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(CreateUserRequest other) {
            name(other.getName());
            return this;
        }

        @java.lang.Override
        @JsonSetter("name")
        public _FinalStage name(String name) {
            this.name = name;
            return this;
        }

        @java.lang.Override
        public CreateUserRequest build() {
            return new CreateUserRequest(name, additionalProperties);
        }
    }
}
