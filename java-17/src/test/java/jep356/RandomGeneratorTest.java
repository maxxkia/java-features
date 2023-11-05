package jep356;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.random.RandomGenerator;
import java.util.random.RandomGeneratorFactory;
import org.junit.jupiter.api.Test;

public class RandomGeneratorTest {

  @Test
  void randomGenerator() {
    List<RandomGeneratorFactory<RandomGenerator>> randomGenerators = RandomGeneratorFactory.all().toList();
    randomGenerators.forEach(factory -> {
      RandomGenerator randomGenerator = factory.create();
      randomGenerator.nextLong();
    });

    assertThat(randomGenerators).isNotEmpty();
  }

}
