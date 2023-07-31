package jep431;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.SequencedCollection;
import java.util.SequencedMap;
import java.util.SequencedSet;
import org.junit.jupiter.api.Test;

public class SequencedCollectionTest {

  @Test
  void sequencedCollection() {
    SequencedCollection<String> sequencedCollection = new ArrayList<>();

    sequencedCollection.addFirst("one");
    sequencedCollection.addFirst("two");
    sequencedCollection.addLast("three");

    assertThat(sequencedCollection).containsSequence("two", "one", "three");
    assertThat(sequencedCollection.reversed()).containsSequence("three", "one", "two");
  }

  @Test
  void sequencedSet() {
    SequencedSet<String> sequencedSet = new LinkedHashSet<>();

    sequencedSet.addFirst("two");
    sequencedSet.addFirst("one");
    sequencedSet.addLast("three");

    assertThat(sequencedSet).containsSequence("one", "two", "three");
  }

  @Test
  void sequencedMap() {
    SequencedMap<Integer, String> sequencedMap = new LinkedHashMap<>();

    sequencedMap.putFirst(2, "two");
    sequencedMap.putFirst(1, "one");
    sequencedMap.putLast(3, "three");

    assertThat(sequencedMap.sequencedKeySet()).containsSequence(1, 2, 3);
  }
}
