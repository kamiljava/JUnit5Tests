package katacalculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowableOfType;

public class StringcalculatorTest {

  @DisplayName("Wpisano  string - zwrócono liczbę")
  @ParameterizedTest(name = "expecting {1} when given {0}")
  // @formatter:off
  @CsvSource({
          "  '',0  ",
          " '1',1  ",
          " '2',2  ",
          " '1,2',3",
          " '150,20',170",
          " '10,20,30',60",
          " '1\n2,3',6",
          " '//;\n1;2',3",
          " '//;\n1;2,3\n4',10",
          " '//%!@\n1%!@2,3\n4',10"
  })
  // @formatter:on
  void test(String numbers, int expectedSum) {
    //when
    int result = StringCalculator.add(numbers);

    //then
    Assertions.assertThat(result).isEqualTo(expectedSum);
  }

  // @formatter:off
  @DisplayName("given numbers string with negative numbers, then throw exception")
  @ParameterizedTest(name = "input: {0}, expected exception message: {1}")
  @CsvSource({
          " '-1','negatives not allowed: -1' ",
          " '-2','negatives not allowed: -2' ",
          " '-1,-2','negatives not allowed: -1,-2' ",
          " '-1,5,-2','negatives not allowed: -1,-2' ",
          " '//%!@\n1%!@-2,3\n-4','negatives not allowed: -2,-4'"
  })
  // @formatter:on
  void testEx(String numbersString, String expectedExceptionMsg) {
    // when
    IllegalArgumentException exception = catchThrowableOfType(
            () -> StringCalculator.add(numbersString),
            IllegalArgumentException.class);

    // then
    assertThat(exception).isNotNull();
    assertThat(exception).hasMessage(expectedExceptionMsg);
  }
}
