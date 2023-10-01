/**
 * This file was auto-generated by Fern from our API Definition.
 */

package resources.commons.types;

import com.fasterxml.jackson.annotation.JsonValue;
import java.lang.Override;
import java.lang.String;

public enum Language {
  JAVA("JAVA"),

  JAVASCRIPT("JAVASCRIPT"),

  PYTHON("PYTHON");

  private final String value;

  Language(String value) {
    this.value = value;
  }

  @JsonValue
  @Override
  public String toString() {
    return this.value;
  }
}
