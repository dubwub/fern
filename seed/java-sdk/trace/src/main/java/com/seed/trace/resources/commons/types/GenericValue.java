/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.seed.trace.resources.commons.types;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.seed.trace.core.ObjectMappers;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = GenericValue.Builder.class)
public final class GenericValue {
    private final Optional<String> stringifiedType;

    private final String stringifiedValue;

    private final Map<String, Object> additionalProperties;

    private GenericValue(
            Optional<String> stringifiedType, String stringifiedValue, Map<String, Object> additionalProperties) {
        this.stringifiedType = stringifiedType;
        this.stringifiedValue = stringifiedValue;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("stringifiedType")
    public Optional<String> getStringifiedType() {
        return stringifiedType;
    }

    @JsonProperty("stringifiedValue")
    public String getStringifiedValue() {
        return stringifiedValue;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof GenericValue && equalTo((GenericValue) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(GenericValue other) {
        return stringifiedType.equals(other.stringifiedType) && stringifiedValue.equals(other.stringifiedValue);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.stringifiedType, this.stringifiedValue);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static StringifiedValueStage builder() {
        return new Builder();
    }

    public interface StringifiedValueStage {
        _FinalStage stringifiedValue(String stringifiedValue);

        Builder from(GenericValue other);
    }

    public interface _FinalStage {
        GenericValue build();

        _FinalStage stringifiedType(Optional<String> stringifiedType);

        _FinalStage stringifiedType(String stringifiedType);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements StringifiedValueStage, _FinalStage {
        private String stringifiedValue;

        private Optional<String> stringifiedType = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(GenericValue other) {
            stringifiedType(other.getStringifiedType());
            stringifiedValue(other.getStringifiedValue());
            return this;
        }

        @java.lang.Override
        @JsonSetter("stringifiedValue")
        public _FinalStage stringifiedValue(String stringifiedValue) {
            this.stringifiedValue = stringifiedValue;
            return this;
        }

        @java.lang.Override
        public _FinalStage stringifiedType(String stringifiedType) {
            this.stringifiedType = Optional.of(stringifiedType);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "stringifiedType", nulls = Nulls.SKIP)
        public _FinalStage stringifiedType(Optional<String> stringifiedType) {
            this.stringifiedType = stringifiedType;
            return this;
        }

        @java.lang.Override
        public GenericValue build() {
            return new GenericValue(stringifiedType, stringifiedValue, additionalProperties);
        }
    }
}
