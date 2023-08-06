package jep441;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import java.util.SequencedCollection;
import java.util.SequencedMap;
import java.util.TreeMap;
import org.junit.jupiter.api.Test;

public class SwitchPatternMatchingTest {

  @Test
  void testPatternMatching() {
    assertThat(getTypename(List.of())).isEqualTo("SequencedCollection type");
    assertThat(getTypename(new TreeMap<>())).isEqualTo("SequencedMap type");
    assertThat(getTypename(Map.of())).isEqualTo("unknown type");
    assertThat(getTypename(null)).isEqualTo("NULL");
  }

  private String getTypename(Object c) {
    return switch(c) {
      // now you can use null as a selector
      case null -> "NULL";
      // you can use types as selector too
      case SequencedCollection sc -> "SequencedCollection type";
      case SequencedMap sm -> "SequencedMap type";
      // default statement is required to cover all possible cases
      default -> "unknown type";
    };
  }

  // you can use `case` statement within switch
  @Test
  void testCaseRefinement() {
    assertThat(getStandardizedPrompt("Yes")).isEqualTo("true");
    assertThat(getStandardizedPrompt("No")).isEqualTo("false");
    assertThat(getStandardizedPrompt("Hello")).isEqualTo("undefined prompt");
  }
  private String getStandardizedPrompt(Object prompt) {
    return switch(prompt) {
      case String s
          when s.equalsIgnoreCase("true")
          || s.equalsIgnoreCase("yes")
          || s.equalsIgnoreCase("y") -> "true";
      case String s
        when s.equalsIgnoreCase("false")
        || s.equalsIgnoreCase("no")
        || s.equalsIgnoreCase("n") -> "false";

      default -> "undefined prompt";
    };
  }

  /* relaxed code syntax for enum case selector
    you can directly use enum types in case statements without prior disambiguation of the type
  * */

  @Test
  void testRelaxedEnumSelector() {
    assertThat(toStringForm(IndividualContributor.L2)).isEqualTo("IC-L2");
    assertThat(toStringForm(IndividualContributor.L3)).isEqualTo("IC-L3");
  }

  sealed interface EmployeeType { }
  enum IndividualContributor implements EmployeeType { L1, L2, L3}
  enum Manager implements EmployeeType {}

  private String toStringForm(EmployeeType etype) {
    return switch (etype) {
      case IndividualContributor.L1 -> "IC-L1";
      case IndividualContributor.L2 -> "IC-L2";
      case IndividualContributor.L3 -> "IC-L3";
      case Manager m -> "Manager";
      default -> throw new IllegalArgumentException("unknown type: " + etype);
    };
  }
}
