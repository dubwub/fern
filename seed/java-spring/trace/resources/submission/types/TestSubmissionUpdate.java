/**
 * This file was auto-generated by Fern from our API Definition.
 */

package resources.submission.types;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import core.ObjectMappers;
import java.lang.Object;
import java.lang.String;
import java.time.OffsetDateTime;
import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_ABSENT)
@JsonDeserialize(
    builder = TestSubmissionUpdate.Builder.class
)
public final class TestSubmissionUpdate {
  private final OffsetDateTime updateTime;

  private final TestSubmissionUpdateInfo updateInfo;

  private TestSubmissionUpdate(OffsetDateTime updateTime, TestSubmissionUpdateInfo updateInfo) {
    this.updateTime = updateTime;
    this.updateInfo = updateInfo;
  }

  @JsonProperty("updateTime")
  public OffsetDateTime getUpdateTime() {
    return updateTime;
  }

  @JsonProperty("updateInfo")
  public TestSubmissionUpdateInfo getUpdateInfo() {
    return updateInfo;
  }

  @java.lang.Override
  public boolean equals(Object other) {
    if (this == other) return true;
    return other instanceof TestSubmissionUpdate && equalTo((TestSubmissionUpdate) other);
  }

  private boolean equalTo(TestSubmissionUpdate other) {
    return updateTime.equals(other.updateTime) && updateInfo.equals(other.updateInfo);
  }

  @java.lang.Override
  public int hashCode() {
    return Objects.hash(this.updateTime, this.updateInfo);
  }

  @java.lang.Override
  public String toString() {
    return ObjectMappers.stringify(this);
  }

  public static UpdateTimeStage builder() {
    return new Builder();
  }

  public interface UpdateTimeStage {
    UpdateInfoStage updateTime(OffsetDateTime updateTime);

    Builder from(TestSubmissionUpdate other);
  }

  public interface UpdateInfoStage {
    _FinalStage updateInfo(TestSubmissionUpdateInfo updateInfo);
  }

  public interface _FinalStage {
    TestSubmissionUpdate build();
  }

  @JsonIgnoreProperties(
      ignoreUnknown = true
  )
  public static final class Builder implements UpdateTimeStage, UpdateInfoStage, _FinalStage {
    private OffsetDateTime updateTime;

    private TestSubmissionUpdateInfo updateInfo;

    private Builder() {
    }

    @java.lang.Override
    public Builder from(TestSubmissionUpdate other) {
      updateTime(other.getUpdateTime());
      updateInfo(other.getUpdateInfo());
      return this;
    }

    @java.lang.Override
    @JsonSetter("updateTime")
    public UpdateInfoStage updateTime(OffsetDateTime updateTime) {
      this.updateTime = updateTime;
      return this;
    }

    @java.lang.Override
    @JsonSetter("updateInfo")
    public _FinalStage updateInfo(TestSubmissionUpdateInfo updateInfo) {
      this.updateInfo = updateInfo;
      return this;
    }

    @java.lang.Override
    public TestSubmissionUpdate build() {
      return new TestSubmissionUpdate(updateTime, updateInfo);
    }
  }
}
