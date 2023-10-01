/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.seed.examples.model.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.seed.examples.core.ObjectMappers;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(builder = Request.Builder.class)
public final class Request {
    private final Object request;

    private Request(Object request) {
        this.request = request;
    }

    @JsonProperty("request")
    public Object getRequest() {
        return request;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof Request && equalTo((Request) other);
    }

    private boolean equalTo(Request other) {
        return request.equals(other.request);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.request);
    }

    @Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static RequestStage builder() {
        return new Builder();
    }

    public interface RequestStage {
        _FinalStage request(Object request);

        Builder from(Request other);
    }

    public interface _FinalStage {
        Request build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements RequestStage, _FinalStage {
        private Object request;

        private Builder() {}

        @Override
        public Builder from(Request other) {
            request(other.getRequest());
            return this;
        }

        @Override
        @JsonSetter("request")
        public _FinalStage request(Object request) {
            this.request = request;
            return this;
        }

        @Override
        public Request build() {
            return new Request(request);
        }
    }
}
