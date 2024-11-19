import java.util.List;
import java.util.stream.Stream;

public class StreamUsage {
  public static void main(String[] args) {
    var sentences = List.of("Hello world!", "This is a longer sentence.", "Another long sentence here.");
    var numbers = List.of(5, 15, 0, 3, 26, -9, 7, 18);
    var showcase = new StreamUsage();

//    var list = showcase.longWithUpperSnakeCase(sentences);
//    list.forEach(System.out::println);
//    showcase.lazyEvaluationShowcase(sentences);
//    showcase.shortCircuitingShowcase(sentences);
//    showcase.filterOrderedShowcase(numbers);
    showcase.returningStreamsShowcase(numbers);
  }

  List<String> longWithUpperSnakeCase(List<String> sentences) {
    return sentences.stream()
        .filter(sentence -> sentence.length() > 15)
        .map(String::toUpperCase)
        .map(sentence -> sentence.replace(" ", "_"))
        .toList();
  }

  void lazyEvaluationShowcase(List<String> sentences) {
    sentences.stream()
        .filter(sentence -> {
          System.out.println("Filtering: " + sentence);
          return sentence.length() > 15;
        })
        .map(sentence -> {
          System.out.println("Uppercasing: " + sentence);
          return sentence.toUpperCase();
        })
        .map(sentence -> {
          System.out.println("Underscoring: " + sentence);
          return sentence.replace(" ", "_");
        })
//            .peek(sentence -> System.out.println("End result: " + sentence))
            .forEach(sentence -> System.out.println("End result: " + sentence));
  }

  void shortCircuitingShowcase(List<String> sentences) {
    sentences.stream()
        .filter(sentence -> {
          System.out.println("Filtering: " + sentence);
          return sentence.length() > 15;
        })
        .map(sentence -> {
          System.out.println("Uppercasing: " + sentence);
          return sentence.toUpperCase();
        })
        .map(sentence -> {
          System.out.println("Underscoring: " + sentence);
          return sentence.replace(" ", "_");
        })
//        .limit(1)
        .forEach(sentence -> System.out.println("End result: " + sentence));
  }

  void filterOrderedShowcase(List<Integer> numbers) {
    var orderedNumbers = numbers.stream()
        .sorted()
        .toList();
    System.out.println("ORDERED NUMBERS: " + orderedNumbers);
    System.out.println();

    System.out.println("FILTERING < 10");
    orderedNumbers.stream()
        .filter(n -> n < 10)
        .forEach(System.out::println);

    System.out.println("\nWHAT IS GOING ON");
    orderedNumbers.stream()
        .filter(n -> {
          System.out.println("Evaluating: " + n);
          return n < 10;
        })
        .forEach(System.out::println);

    System.out.println("\nBETTER WAY");
    orderedNumbers.stream()
        .takeWhile(n -> {
          System.out.println("Evaluating: " + n);
          return n < 10;
        })
        .forEach(System.out::println);
  }

  Stream<Integer> streamSmallNumbers(List<Integer> numbers) {
    return numbers.stream()
        .filter(n -> n < 10);
  }

  void returningStreamsShowcase(List<Integer> numbers) {
    var smallNumbers = streamSmallNumbers(numbers);
    smallNumbers.forEach(System.out::println);
//    var listOfSmallNumbers = smallNumbers.toList();
    carefulWithStreamArguments(smallNumbers);
  }

  void carefulWithStreamArguments(Stream<Integer> streamOfNumbers) {
    streamOfNumbers.forEach(System.out::println);
  }
}