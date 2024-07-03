/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.seed.fileUpload.resources.service.requests;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.Nulls;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.seed.fileUpload.core.ObjectMappers;
import com.seed.fileUpload.resources.service.types.MyObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = MyRequest.Builder.class)
public final class MyRequest {
    private final Optional<String> maybeString;

    private final int integer;

    private final Optional<Integer> maybeInteger;

    private final Optional<List<String>> optionalListOfStrings;

    private final List<MyObject> listOfObjects;

    private final Map<String, Object> additionalProperties;

    private MyRequest(
            Optional<String> maybeString,
            int integer,
            Optional<Integer> maybeInteger,
            Optional<List<String>> optionalListOfStrings,
            List<MyObject> listOfObjects,
            Map<String, Object> additionalProperties) {
        this.maybeString = maybeString;
        this.integer = integer;
        this.maybeInteger = maybeInteger;
        this.optionalListOfStrings = optionalListOfStrings;
        this.listOfObjects = listOfObjects;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("maybeString")
    public Optional<String> getMaybeString() {
        return maybeString;
    }

    @JsonProperty("integer")
    public int getInteger() {
        return integer;
    }

    @JsonProperty("maybeInteger")
    public Optional<Integer> getMaybeInteger() {
        return maybeInteger;
    }

    @JsonProperty("optionalListOfStrings")
    public Optional<List<String>> getOptionalListOfStrings() {
        return optionalListOfStrings;
    }

    @JsonProperty("listOfObjects")
    public List<MyObject> getListOfObjects() {
        return listOfObjects;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof MyRequest && equalTo((MyRequest) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(MyRequest other) {
        return maybeString.equals(other.maybeString)
                && integer == other.integer
                && maybeInteger.equals(other.maybeInteger)
                && optionalListOfStrings.equals(other.optionalListOfStrings)
                && listOfObjects.equals(other.listOfObjects);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(
                this.maybeString, this.integer, this.maybeInteger, this.optionalListOfStrings, this.listOfObjects);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static IntegerStage builder() {
        return new Builder();
    }

    public interface IntegerStage {
        _FinalStage integer(int integer);

        Builder from(MyRequest other);
    }

    public interface _FinalStage {
        MyRequest build();

        _FinalStage maybeString(Optional<String> maybeString);

        _FinalStage maybeString(String maybeString);

        _FinalStage maybeInteger(Optional<Integer> maybeInteger);

        _FinalStage maybeInteger(Integer maybeInteger);

        _FinalStage optionalListOfStrings(Optional<List<String>> optionalListOfStrings);

        _FinalStage optionalListOfStrings(List<String> optionalListOfStrings);

        _FinalStage listOfObjects(List<MyObject> listOfObjects);

        _FinalStage addListOfObjects(MyObject listOfObjects);

        _FinalStage addAllListOfObjects(List<MyObject> listOfObjects);
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements IntegerStage, _FinalStage {
        private int integer;

        private List<MyObject> listOfObjects = new ArrayList<>();

        private Optional<List<String>> optionalListOfStrings = Optional.empty();

        private Optional<Integer> maybeInteger = Optional.empty();

        private Optional<String> maybeString = Optional.empty();

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(MyRequest other) {
            maybeString(other.getMaybeString());
            integer(other.getInteger());
            maybeInteger(other.getMaybeInteger());
            optionalListOfStrings(other.getOptionalListOfStrings());
            listOfObjects(other.getListOfObjects());
            return this;
        }

        @java.lang.Override
        @JsonSetter("integer")
        public _FinalStage integer(int integer) {
            this.integer = integer;
            return this;
        }

        @java.lang.Override
        public _FinalStage addAllListOfObjects(List<MyObject> listOfObjects) {
            this.listOfObjects.addAll(listOfObjects);
            return this;
        }

        @java.lang.Override
        public _FinalStage addListOfObjects(MyObject listOfObjects) {
            this.listOfObjects.add(listOfObjects);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "listOfObjects", nulls = Nulls.SKIP)
        public _FinalStage listOfObjects(List<MyObject> listOfObjects) {
            this.listOfObjects.clear();
            this.listOfObjects.addAll(listOfObjects);
            return this;
        }

        @java.lang.Override
        public _FinalStage optionalListOfStrings(List<String> optionalListOfStrings) {
            this.optionalListOfStrings = Optional.of(optionalListOfStrings);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "optionalListOfStrings", nulls = Nulls.SKIP)
        public _FinalStage optionalListOfStrings(Optional<List<String>> optionalListOfStrings) {
            this.optionalListOfStrings = optionalListOfStrings;
            return this;
        }

        @java.lang.Override
        public _FinalStage maybeInteger(Integer maybeInteger) {
            this.maybeInteger = Optional.of(maybeInteger);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "maybeInteger", nulls = Nulls.SKIP)
        public _FinalStage maybeInteger(Optional<Integer> maybeInteger) {
            this.maybeInteger = maybeInteger;
            return this;
        }

        @java.lang.Override
        public _FinalStage maybeString(String maybeString) {
            this.maybeString = Optional.of(maybeString);
            return this;
        }

        @java.lang.Override
        @JsonSetter(value = "maybeString", nulls = Nulls.SKIP)
        public _FinalStage maybeString(Optional<String> maybeString) {
            this.maybeString = maybeString;
            return this;
        }

        @java.lang.Override
        public MyRequest build() {
            return new MyRequest(
                    maybeString, integer, maybeInteger, optionalListOfStrings, listOfObjects, additionalProperties);
        }
    }
}
