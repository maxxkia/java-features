package jep409;

public class SealedClassTest {
  sealed interface Diet {}
  non-sealed class Vegan implements Diet {}
  non-sealed class Vegetarian implements Diet {}
  final class Omnivore implements Diet {}
}
