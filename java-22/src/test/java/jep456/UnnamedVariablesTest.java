package jep456;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Test;

public class UnnamedVariablesTest {

  @Test
  void unnamedVariable() {
    AtomicInteger counter = new AtomicInteger(0);
    IntStream.range(1, 15)
        .forEach(_ -> counter.addAndGet(1));
    assertThat(counter.get()).isEqualTo(14);
  }

  @Test
  void unnamedPatternVariable() {
    Shape shape = null;

    String status = switch (shape) {
      // multiple patterns in case label are now possible
      case Rectangle _, Square _ -> "right angles";
      case Circle _ -> "round";
      case null -> "N/A";
    };

    assertThat(status).isEqualTo("N/A");
  }

  sealed interface Shape {}

  final class Rectangle implements Shape {}

  final class Square implements Shape {}

  final class Circle implements Shape {}
}
