package jep395;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class FileInfoTest {

  @Test
  void shouldValidateName() {
    assertThatThrownBy(() -> new FileInfo(null, 15))
        .isInstanceOf(NullPointerException.class);
  }

  @Test
  void shouldNormalizeName() {
    FileInfo fileInfo = new FileInfo("my-file.java   ", 1);

    assertThat(fileInfo.filename()).isEqualTo("my-file.java");
  }
}
