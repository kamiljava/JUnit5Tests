package katacalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringJoinerCalculator {
  public static int add(String inputString) {
    if (inputString.isEmpty()) {
      return 0;
    }

    List<Integer> numbers = parseNumbers(inputString);
    StringJoiner stringJoiner = new StringJoiner(",");
    for (Integer integer : numbers) {
      if (integer < 0) {
        stringJoiner.add(integer.toString());
      }
    }
    if (stringJoiner.length() != 0) {
      String returnedNumbers = stringJoiner.toString();
      throw new IllegalArgumentException("negatives not allowed: " + returnedNumbers);
    }
    return numbers.stream().reduce(Integer::sum).orElse(0);
  }

  private static List<Integer> parseNumbers(String inputString) {
    String splitRegex = ",|\n";
    int firstNewLineCharIndex = inputString.indexOf('\n');
    if (inputString.startsWith("//")) {
      splitRegex = splitRegex.concat("|" + inputString.substring(2, firstNewLineCharIndex));
      inputString = inputString.substring(firstNewLineCharIndex + 1);

    }
    return Stream.of(inputString.split(splitRegex)).map(Integer::parseInt).collect(Collectors.toList());
  }
}


