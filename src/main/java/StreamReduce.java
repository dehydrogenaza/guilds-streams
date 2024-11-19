import java.util.ArrayList;
import java.util.List;

public class StreamReduce {
  public static void main(String[] args) {
    var words = List.of("hello", "java", "guild", "are", "you", "entertained");
    var showcase = new StreamReduce();

    System.out.println(showcase.longestWord1(words));
    System.out.println(showcase.longestWord2(words));
    System.out.println(showcase.longestWord2AlmostEquivalent(words));
    System.out.println(showcase.longestWord3(words));
    System.out.println(showcase.longestWord4(words));
    System.out.println(showcase.longestWord5(words));
    System.out.println(showcase.longestWord6(words));
  }

  int longestWord1(List<String> words) {
    System.out.println("Using a specialized IntStream");
    return words.stream()
        .mapToInt(String::length)
        .max()
        .orElse(0);
  }

  int longestWord2(List<String> words) {
    System.out.println("Using an accumulation operator");
    return words.stream()
        .map(String::length)
        .reduce(0, (acc, curr) -> {
          if (acc > curr) {
            return acc;
          }
          return curr;
        });
  }

  int longestWord2AlmostEquivalent(List<String> words) {
    System.out.println("Using the good ol' loop");

    List<Integer> lengths = new ArrayList<>();
    for (var word : words) {
      lengths.add(word.length());
    }

    int acc = 0;
    for (var curr : lengths) {
      acc = Integer.max(acc, curr);
    }

    return acc;
  }

  int longestWord3(List<String> words) {
    System.out.println("Using an accumulation operator with a ternary operator");
    return words.stream()
        .map(String::length)
        .reduce(0, (acc, curr) -> acc > curr ? acc : curr);
  }

  int longestWord4(List<String> words) {
    System.out.println("Using an accumulation operator through a method reference");
    return words.stream()
        .map(String::length)
        .reduce(0, Integer::max);
  }

  //this is called "reduce" in Kotlin, while the other examples are called "fold"
  int longestWord5(List<String> words) {
    System.out.println("With identity equal to the first element");
    return words.stream()
        .map(String::length)
        .reduce(Integer::max)
        .orElse(0);
  }

  int longestWord6(List<String> words) {
    System.out.println("Using a mapping reducer");
    return words.stream()
        .reduce(0, (acc, curr) -> acc > curr.length() ? acc : curr.length(), Integer::max);
  }
}
