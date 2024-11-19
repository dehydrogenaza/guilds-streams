import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamFilter {
  List<String> filterFullNames(List<String> names) {
    return names.stream()
        .filter(name -> name.contains(" "))
        .toList();
  }

  Set<Integer> filterUniqueEvenInts(Integer[] numbers) {
    return Arrays.stream(numbers)
        .filter(num -> num % 2 == 0)
//                .distinct()
        .collect(Collectors.toSet());
  }

  Double averageFromEvenInts(int[] numbers) {
    return Arrays.stream(numbers)
        .filter(this::isEven)
        .average()
        .orElse(0);
  }

  private boolean isEven(int num) {
    return num % 2 == 0;
  }
}
