import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class StreamGrouping {
  public static void main(String[] args) {
    var words = List.of("hello", "java", "guild", "are", "you", "entertained");
    var showcase = new StreamGrouping();

    System.out.println(showcase.groupByLength(words));
    System.out.println(showcase.groupByLengthAndCombine(words));
    System.out.println(showcase.groupByWithSpecificMap1(words));
    System.out.println(showcase.groupByWithSpecificMap2(words));
    System.out.println(showcase.partitionByLength(words));
  }

  Map<Integer, List<String>> groupByLength(List<String> words) {
    System.out.println("\nMap words to lengths in a HashMap, results are in a List");
    return words.stream()
        .collect(Collectors.groupingBy(String::length));
  }

  Map<Integer, String> groupByLengthAndCombine(List<String> words) {
    System.out.println("\nMap words to lengths in a HashMap, results are further transformed");
    return words.stream()
        .collect(Collectors.groupingBy(String::length, Collectors.joining(", ")));
  }

  TreeMap<Integer, String> groupByWithSpecificMap1(List<String> words) {
    System.out.println("\nMap words to lengths in a specified map, results are further transformed");
    return words.stream()
        .collect(Collectors.groupingBy(String::length, TreeMap::new, Collectors.joining(", ")));
  }

  TreeMap<Integer, List<String>> groupByWithSpecificMap2(List<String> words) {
    System.out.println("\nMap words to lengths in a specified map, results are in a List (there is not shortcut for this)");
    return words.stream()
        .collect(Collectors.groupingBy(String::length, TreeMap::new, Collectors.toList()));
  }

  Map<Boolean, List<String>> partitionByLength(List<String> words) {
    System.out.println("\nMap words to true/false based on the predicate");
    return words.stream()
        .collect(Collectors.partitioningBy(word -> word.length() > 4));
  }
}
