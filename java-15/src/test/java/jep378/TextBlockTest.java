package jep378;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class TextBlockTest {

  @Test
  void simpleTextBlock() {
    String block = """
        This one
        text
        """;

    assertThat(block).isEqualTo("This one\ntext\n");
  }

  @Test
  void textBlockWithoutLineBreaks() {
    String block = """
        this \
        text \
        block does not have new lines""";

    assertThat(block).isEqualTo("this text block does not have new lines");
  }
}
