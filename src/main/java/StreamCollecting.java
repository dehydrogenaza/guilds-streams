import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.stream.Collectors;

public class StreamCollecting {
  public static void main(String[] args) {
    var words = List.of("hello", "java", "guild", "are", "you", "entertained");
    var showcase = new StreamCollecting();

    //same? or not?
    var list1 = showcase.toLengthsList1(words);
    var list2 = showcase.toLengthsList2(words);

    System.out.println(list1);
    System.out.println(list2);

    System.out.println(showcase.toLengthsSet(words));
    System.out.println(showcase.toAnyCollectionOfLengths(words));

    System.out.println(showcase.toUpperCaseSentence1(words));
    System.out.println(showcase.toUpperCaseSentence2(words));
  }

  List<Integer> toLengthsList1(List<String> words) {
    return words.stream()
        .map(String::length)
        .collect(Collectors.toList());
  }

  List<Integer> toLengthsList2(List<String> words) {
    return words.stream()
        .map(String::length)
        .toList();
  }

  Set<Integer> toLengthsSet(List<String> words) {
    System.out.println("\nTo a set");
    return words.stream()
        .map(String::length)
        .collect(Collectors.toSet());
  }

  ConcurrentSkipListSet<Integer> toAnyCollectionOfLengths(List<String> words) {
    System.out.println("\nTo some other Collection");
    return words.stream()
        .map(String::length)
        .collect(Collectors.toCollection(ConcurrentSkipListSet::new));
  }

  String toUpperCaseSentence1(List<String> words) {
    System.out.println("\nTo a string (no separator)");
    return words.stream()
        .map(String::toUpperCase)
        .collect(Collectors.joining());
  }

  String toUpperCaseSentence2(List<String> words) {
    System.out.println("\nTo a string (with separator)");
    return words.stream()
        .map(String::toUpperCase)
        .collect(Collectors.joining(" / "));
  }
}
