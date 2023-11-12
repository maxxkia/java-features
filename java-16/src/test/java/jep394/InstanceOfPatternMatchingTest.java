package jep394;

import static org.assertj.core.api.Assertions.fail;

import java.util.Collection;
import java.util.List;
import org.junit.jupiter.api.Test;

public class InstanceOfPatternMatchingTest {

  @Test
  void patternMatchingTest() {
    if (getCollection() instanceof List<?> list && !list.isEmpty()) {
      return;
    }

    fail("Unreachable code!");
  }

  private static Collection<?> getCollection() {
    return List.of(1, 3, 5);
  }
}
