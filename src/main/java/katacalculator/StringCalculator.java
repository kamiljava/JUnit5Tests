package katacalculator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringCalculator {
  public static int add(String inputString) {
    if (inputString.isEmpty()) {
      return 0;
    }

    List<Integer> numbersAsString = parseNumbers(inputString);
    String negativesNumbersPartExMsg = numbersAsString.stream().filter(i -> i < 0)
            .map(i -> i.toString())
            .collect(Collectors.joining(","));
    if (!negativesNumbersPartExMsg.isEmpty())
      throw new IllegalArgumentException("negatives not allowed: " + negativesNumbersPartExMsg);

    return numbersAsString.stream().reduce(Integer::sum).orElse(0);
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


