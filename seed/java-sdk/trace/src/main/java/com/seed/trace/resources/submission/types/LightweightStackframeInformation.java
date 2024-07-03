/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.seed.trace.resources.submission.types;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.seed.trace.core.ObjectMappers;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(builder = LightweightStackframeInformation.Builder.class)
public final class LightweightStackframeInformation {
    private final int numStackFrames;

    private final String topStackFrameMethodName;

    private final Map<String, Object> additionalProperties;

    private LightweightStackframeInformation(
            int numStackFrames, String topStackFrameMethodName, Map<String, Object> additionalProperties) {
        this.numStackFrames = numStackFrames;
        this.topStackFrameMethodName = topStackFrameMethodName;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("numStackFrames")
    public int getNumStackFrames() {
        return numStackFrames;
    }

    @JsonProperty("topStackFrameMethodName")
    public String getTopStackFrameMethodName() {
        return topStackFrameMethodName;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof LightweightStackframeInformation && equalTo((LightweightStackframeInformation) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(LightweightStackframeInformation other) {
        return numStackFrames == other.numStackFrames && topStackFrameMethodName.equals(other.topStackFrameMethodName);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.numStackFrames, this.topStackFrameMethodName);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static NumStackFramesStage builder() {
        return new Builder();
    }

    public interface NumStackFramesStage {
        TopStackFrameMethodNameStage numStackFrames(int numStackFrames);

        Builder from(LightweightStackframeInformation other);
    }

    public interface TopStackFrameMethodNameStage {
        _FinalStage topStackFrameMethodName(String topStackFrameMethodName);
    }

    public interface _FinalStage {
        LightweightStackframeInformation build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder implements NumStackFramesStage, TopStackFrameMethodNameStage, _FinalStage {
        private int numStackFrames;

        private String topStackFrameMethodName;

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(LightweightStackframeInformation other) {
            numStackFrames(other.getNumStackFrames());
            topStackFrameMethodName(other.getTopStackFrameMethodName());
            return this;
        }

        @java.lang.Override
        @JsonSetter("numStackFrames")
        public TopStackFrameMethodNameStage numStackFrames(int numStackFrames) {
            this.numStackFrames = numStackFrames;
            return this;
        }

        @java.lang.Override
        @JsonSetter("topStackFrameMethodName")
        public _FinalStage topStackFrameMethodName(String topStackFrameMethodName) {
            this.topStackFrameMethodName = topStackFrameMethodName;
            return this;
        }

        @java.lang.Override
        public LightweightStackframeInformation build() {
            return new LightweightStackframeInformation(numStackFrames, topStackFrameMethodName, additionalProperties);
        }
    }
}
