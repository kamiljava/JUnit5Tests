package fizzbuzz;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class FizzBuzzTest {

    @DisplayName(
            "should return Fizz if division 3, "+
            "if division 5 should return Buzz, if division 5 and 3 should return Fizz Buzz, " +
            " if is other number we get String number"
    )
    @ParameterizedTest(name = "number:(0) msgExpected(1)")
    @CsvSource({
            "1,1",
            "3,Fizz",
            "5,Buzz",
            "9,Fizz",
            "15,FizzBuzz",
            "30,FizzBuzz,",
            "22,22"
    })
    void test0(int number, String msgExpected) throws Exception {
        //given

        //when
        String msg = FizzBuzz.msg(number);

        //then
        assertThat(msg).isEqualTo(msgExpected);
    }

}
