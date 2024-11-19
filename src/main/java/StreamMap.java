import java.util.List;

public class StreamMap {
  List<String> mapToUpperCase(List<String> names) {
    return names.stream()
        .map(String::toUpperCase)
        .toList();
  }

  List<Boolean> mapToLength(List<String> names) {
    return names.stream()
        .map(String::length)
        .map(l -> l > 10)
        .toList();
  }

  static class Box {
    final Long id;
    final List<String> content;

    Box(Long id, String... items) {
      this.id = id;
      this.content = List.of(items);
    }

    Long getId() {
      return id;
    }

    List<String> getContent() {
      return content;
    }
  }

  List<String> mapToContents(List<Box> boxes) {
    return boxes.stream()
        .flatMap(box -> box.getContent().stream())
        .toList();

//    return boxes.stream()
//        .map(Box::getContent)
//        .flatMap(List::stream)
//        .toList();
  }

  List<String> efficientMapToContents(List<Box> boxes) {
    return boxes.stream()
        .<String>mapMulti((box, result) -> {
          for (var item : box.getContent()) {
            result.accept(item);
          }
        })
        .toList();
  }
}
