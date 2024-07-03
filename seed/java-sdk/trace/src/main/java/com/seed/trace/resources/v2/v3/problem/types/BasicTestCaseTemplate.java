/**
 * This file was auto-generated by Fern from our API Definition.
 */
package com.seed.trace.resources.v2.v3.problem.types;

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
@JsonDeserialize(builder = BasicTestCaseTemplate.Builder.class)
public final class BasicTestCaseTemplate {
    private final String templateId;

    private final String name;

    private final TestCaseImplementationDescription description;

    private final String expectedValueParameterId;

    private final Map<String, Object> additionalProperties;

    private BasicTestCaseTemplate(
            String templateId,
            String name,
            TestCaseImplementationDescription description,
            String expectedValueParameterId,
            Map<String, Object> additionalProperties) {
        this.templateId = templateId;
        this.name = name;
        this.description = description;
        this.expectedValueParameterId = expectedValueParameterId;
        this.additionalProperties = additionalProperties;
    }

    @JsonProperty("templateId")
    public String getTemplateId() {
        return templateId;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("description")
    public TestCaseImplementationDescription getDescription() {
        return description;
    }

    @JsonProperty("expectedValueParameterId")
    public String getExpectedValueParameterId() {
        return expectedValueParameterId;
    }

    @java.lang.Override
    public boolean equals(Object other) {
        if (this == other) return true;
        return other instanceof BasicTestCaseTemplate && equalTo((BasicTestCaseTemplate) other);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    private boolean equalTo(BasicTestCaseTemplate other) {
        return templateId.equals(other.templateId)
                && name.equals(other.name)
                && description.equals(other.description)
                && expectedValueParameterId.equals(other.expectedValueParameterId);
    }

    @java.lang.Override
    public int hashCode() {
        return Objects.hash(this.templateId, this.name, this.description, this.expectedValueParameterId);
    }

    @java.lang.Override
    public String toString() {
        return ObjectMappers.stringify(this);
    }

    public static TemplateIdStage builder() {
        return new Builder();
    }

    public interface TemplateIdStage {
        NameStage templateId(String templateId);

        Builder from(BasicTestCaseTemplate other);
    }

    public interface NameStage {
        DescriptionStage name(String name);
    }

    public interface DescriptionStage {
        ExpectedValueParameterIdStage description(TestCaseImplementationDescription description);
    }

    public interface ExpectedValueParameterIdStage {
        _FinalStage expectedValueParameterId(String expectedValueParameterId);
    }

    public interface _FinalStage {
        BasicTestCaseTemplate build();
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static final class Builder
            implements TemplateIdStage, NameStage, DescriptionStage, ExpectedValueParameterIdStage, _FinalStage {
        private String templateId;

        private String name;

        private TestCaseImplementationDescription description;

        private String expectedValueParameterId;

        @JsonAnySetter
        private Map<String, Object> additionalProperties = new HashMap<>();

        private Builder() {}

        @java.lang.Override
        public Builder from(BasicTestCaseTemplate other) {
            templateId(other.getTemplateId());
            name(other.getName());
            description(other.getDescription());
            expectedValueParameterId(other.getExpectedValueParameterId());
            return this;
        }

        @java.lang.Override
        @JsonSetter("templateId")
        public NameStage templateId(String templateId) {
            this.templateId = templateId;
            return this;
        }

        @java.lang.Override
        @JsonSetter("name")
        public DescriptionStage name(String name) {
            this.name = name;
            return this;
        }

        @java.lang.Override
        @JsonSetter("description")
        public ExpectedValueParameterIdStage description(TestCaseImplementationDescription description) {
            this.description = description;
            return this;
        }

        @java.lang.Override
        @JsonSetter("expectedValueParameterId")
        public _FinalStage expectedValueParameterId(String expectedValueParameterId) {
            this.expectedValueParameterId = expectedValueParameterId;
            return this;
        }

        @java.lang.Override
        public BasicTestCaseTemplate build() {
            return new BasicTestCaseTemplate(
                    templateId, name, description, expectedValueParameterId, additionalProperties);
        }
    }
}
