package katacalculator;

import fizzbuzz.FizzBuzz;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class KataCalculatorTest {

    //https://osherove.com/tdd-kata-1

    @DisplayName(
            "We want sum two number if numbers are string"
    )
    @ParameterizedTest(name = "numberOne:(0) numberTwo(1)")
    @CsvSource({
            " '',0 ",
            " '1',1 ",
            " '2',2 ",
            " '1,2',3 ",
            " '1\n3,2',6 "
    })
    void test0(String numbers, int sumNumbers) throws Exception {
        //given

        //when
        int sum = KataCalculator.sum(numbers);

        //then
        assertThat(sum).isEqualTo(sumNumbers);
    }

}
