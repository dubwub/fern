/**
 * This file was auto-generated by Fern from our API Definition.
 */

package resources.problem.types;

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
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import resources.commons.types.Language;
import resources.commons.types.TestCaseWithExpectedResult;
import resources.commons.types.VariableType;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonDeserialize(
    builder = CreateProblemRequest.Builder.class
)
public final class CreateProblemRequest {
  private final String problemName;

  private final ProblemDescription problemDescription;

  private final Map<Language, ProblemFiles> files;

  private final List<VariableTypeAndName> inputParams;

  private final VariableType outputType;

  private final List<TestCaseWithExpectedResult> testcases;

  private final String methodName;

  private CreateProblemRequest(String problemName, ProblemDescription problemDescription,
      Map<Language, ProblemFiles> files, List<VariableTypeAndName> inputParams,
      VariableType outputType, List<TestCaseWithExpectedResult> testcases, String methodName) {
    this.problemName = problemName;
    this.problemDescription = problemDescription;
    this.files = files;
    this.inputParams = inputParams;
    this.outputType = outputType;
    this.testcases = testcases;
    this.methodName = methodName;
  }

  @JsonProperty("problemName")
  public String getProblemName() {
    return problemName;
  }

  @JsonProperty("problemDescription")
  public ProblemDescription getProblemDescription() {
    return problemDescription;
  }

  @JsonProperty("files")
  public Map<Language, ProblemFiles> getFiles() {
    return files;
  }

  @JsonProperty("inputParams")
  public List<VariableTypeAndName> getInputParams() {
    return inputParams;
  }

  @JsonProperty("outputType")
  public VariableType getOutputType() {
    return outputType;
  }

  @JsonProperty("testcases")
  public List<TestCaseWithExpectedResult> getTestcases() {
    return testcases;
  }

  @JsonProperty("methodName")
  public String getMethodName() {
    return methodName;
  }

  @Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof CreateProblemRequest && equalTo((CreateProblemRequest) other);
  }

  private boolean equalTo(CreateProblemRequest other) {
    return problemName.equals(other.problemName) && problemDescription.equals(other.problemDescription) && files.equals(other.files) && inputParams.equals(other.inputParams) && outputType.equals(other.outputType) && testcases.equals(other.testcases) && methodName.equals(other.methodName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.problemName, this.problemDescription, this.files, this.inputParams, this.outputType, this.testcases, this.methodName);
  }

  @Override
  public String toString() {
    return ObjectMappers.stringify(this);
  }

  public static ProblemNameStage builder() {
    return new Builder();
  }

  public interface ProblemNameStage {
    ProblemDescriptionStage problemName(String problemName);

    Builder from(CreateProblemRequest other);
  }

  public interface ProblemDescriptionStage {
    OutputTypeStage problemDescription(ProblemDescription problemDescription);
  }

  public interface OutputTypeStage {
    MethodNameStage outputType(VariableType outputType);
  }

  public interface MethodNameStage {
    _FinalStage methodName(String methodName);
  }

  public interface _FinalStage {
    CreateProblemRequest build();

    _FinalStage files(Map<Language, ProblemFiles> files);

    _FinalStage putAllFiles(Map<Language, ProblemFiles> files);

    _FinalStage files(Language key, ProblemFiles value);

    _FinalStage inputParams(List<VariableTypeAndName> inputParams);

    _FinalStage addInputParams(VariableTypeAndName inputParams);

    _FinalStage addAllInputParams(List<VariableTypeAndName> inputParams);

    _FinalStage testcases(List<TestCaseWithExpectedResult> testcases);

    _FinalStage addTestcases(TestCaseWithExpectedResult testcases);

    _FinalStage addAllTestcases(List<TestCaseWithExpectedResult> testcases);
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements ProblemNameStage, ProblemDescriptionStage, OutputTypeStage, MethodNameStage, _FinalStage {
    private String problemName;

    private ProblemDescription problemDescription;

    private VariableType outputType;

    private String methodName;

    private List<TestCaseWithExpectedResult> testcases = new ArrayList<>();

    private List<VariableTypeAndName> inputParams = new ArrayList<>();

    private Map<Language, ProblemFiles> files = new LinkedHashMap<>();

    private Builder() {
    }

    @Override
    public Builder from(CreateProblemRequest other) {
      problemName(other.getProblemName());
      problemDescription(other.getProblemDescription());
      files(other.getFiles());
      inputParams(other.getInputParams());
      outputType(other.getOutputType());
      testcases(other.getTestcases());
      methodName(other.getMethodName());
      return this;
    }

    @Override
    @JsonSetter("problemName")
    public ProblemDescriptionStage problemName(String problemName) {
      this.problemName = problemName;
      return this;
    }

    @Override
    @JsonSetter("problemDescription")
    public OutputTypeStage problemDescription(ProblemDescription problemDescription) {
      this.problemDescription = problemDescription;
      return this;
    }

    @Override
    @JsonSetter("outputType")
    public MethodNameStage outputType(VariableType outputType) {
      this.outputType = outputType;
      return this;
    }

    @Override
    @JsonSetter("methodName")
    public _FinalStage methodName(String methodName) {
      this.methodName = methodName;
      return this;
    }

    @Override
    public _FinalStage addAllTestcases(List<TestCaseWithExpectedResult> testcases) {
      this.testcases.addAll(testcases);
      return this;
    }

    @Override
    public _FinalStage addTestcases(TestCaseWithExpectedResult testcases) {
      this.testcases.add(testcases);
      return this;
    }

    @Override
    @JsonSetter(
        value = "testcases",
        nulls = Nulls.SKIP
    )
    public _FinalStage testcases(List<TestCaseWithExpectedResult> testcases) {
      this.testcases.clear();
      this.testcases.addAll(testcases);
      return this;
    }

    @Override
    public _FinalStage addAllInputParams(List<VariableTypeAndName> inputParams) {
      this.inputParams.addAll(inputParams);
      return this;
    }

    @Override
    public _FinalStage addInputParams(VariableTypeAndName inputParams) {
      this.inputParams.add(inputParams);
      return this;
    }

    @Override
    @JsonSetter(
        value = "inputParams",
        nulls = Nulls.SKIP
    )
    public _FinalStage inputParams(List<VariableTypeAndName> inputParams) {
      this.inputParams.clear();
      this.inputParams.addAll(inputParams);
      return this;
    }

    @Override
    public _FinalStage files(Language key, ProblemFiles value) {
      this.files.put(key, value);
      return this;
    }

    @Override
    public _FinalStage putAllFiles(Map<Language, ProblemFiles> files) {
      this.files.putAll(files);
      return this;
    }

    @Override
    @JsonSetter(
        value = "files",
        nulls = Nulls.SKIP
    )
    public _FinalStage files(Map<Language, ProblemFiles> files) {
      this.files.clear();
      this.files.putAll(files);
      return this;
    }

    @Override
    public CreateProblemRequest build() {
      return new CreateProblemRequest(problemName, problemDescription, files, inputParams, outputType, testcases, methodName);
    }
  }
}
