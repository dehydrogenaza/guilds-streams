import java.util.random.RandomGenerator;
import java.util.stream.Stream;

public class StreamGenerators {
  public static void main(String[] args) {
    var showcase = new StreamGenerators();

    showcase.generateRandoms()
        .limit(10)
        .forEach(System.out::println);

    showcase.generateOrdered()
        .limit(10)
        .forEach(System.out::println);

    showcase.generateOrderedFinite()
        .limit(10)
        .forEach(System.out::println);
  }

  Stream<Integer> generateRandoms() {
    System.out.println("\nGenerating an unordered, potentially infinite Stream, for example static or random numbers");
    return Stream.generate(RandomGenerator.getDefault()::nextInt);
  }

  Stream<Integer> generateOrdered() {
    System.out.println("\nGenerating an ordered, potentially infinite Stream");
    return Stream.iterate(1, i -> i * 2);
  }

  Stream<Integer> generateOrderedFinite() {
    System.out.println("\nGenerating an ordered, finite Stream");
    return Stream.iterate(1, i -> i < 100, i -> i * 2);
  }
}
