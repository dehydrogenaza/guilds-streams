import java.util.List;

public class StreamMappingReduce {
  public static void main(String[] args) {
    var words = List.of("hello", "java", "guild", "are", "you", "entertained");
    var showcase = new StreamMappingReduce();

    System.out.println(showcase.combinedString1(words));
    System.out.println(showcase.combinedString2(words));
    System.out.println(showcase.combinedString3(words));
    System.out.println(showcase.combinedLength1(words));
    System.out.println(showcase.combinedLength2(words));
  }

  String combinedString1(List<String> words) {
    System.out.println("Using an accumulation operator");
    return words.stream()
        .reduce("", (acc, curr) -> acc + curr);
  }

  String combinedString2(List<String> words) {
    System.out.println("Using an accumulation operator through a method reference");
    return words.stream()
        .reduce("", String::concat);
  }

  String combinedString3(List<String> words) {
    System.out.println("With identity equal to the first element");
    return words.stream()
        .reduce(String::concat)
        .orElse("");
  }

  int combinedLength1(List<String> words) {
    System.out.println("Reducing, then mapping the result");
    return words.stream()
        .reduce("", String::concat)
        .length();
  }

  int combinedLength2(List<String> words) {
    System.out.println("Mapping and reducing in a single step");
    return words.stream()
        .reduce(0, (acc, word) -> acc + word.length(), Integer::sum);
  }
}
