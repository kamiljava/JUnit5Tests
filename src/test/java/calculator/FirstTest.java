package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class FirstTest {
    //Dodajemy opis co ma sie wydarzyć i jaki chcemy uzyskać wynik. Najlepiej zacząć od wyniku
// ,a potem od sposobu w jaki sposób chcemy go uzyskać
    @DisplayName(
            "result 5, when sum 4 and 1"
    )
//adnotacja informująca o tym że to będzie calculator i uruchamiająca testy
    @Test
    void test1() throws Exception {

        //given
        int x = 4;
        int y = 1;

        //when
        int sum = Calculator.add(x, y);

        //then
        assertThat(sum).isEqualTo(5);

    }

    //zrobiony calculator który nie przejdzie //////////////////////////////////////////////////////////////////////////////////////
    @DisplayName(
            "result 5, when sum x and y"
    )
    @Test
    void test2() throws Exception {

        //given
        int x = 3;
        int y = 1;

        //when
        int sum = Calculator.add(x, y);

        //then
        assertThat(sum).isEqualTo(5);
    }


    //Testowanie na Stringach ///////////////////////////////////////////////////////////////////////////////////
    @DisplayName(
            "result fullName Janusz Kowalski, when sum name and lastName "
    )
    @Test
    void test3() throws Exception {

        //given
        String name = "Janusz";
        String lastName = "Kowalski";

        //when
        String fullName = name+" "+lastName;

        //then
        assertThat(fullName).isEqualTo("Janusz Kowalski");
    }




    //inny sposób ////////////////////////////////////////////////////////////////////////////////////////
    @DisplayName(
            "should return sum of two integer "
    )
    @ParameterizedTest(name = "given:(0)and (1): expect sum (2)")
    @CsvSource({
            "1,2,3",
            "2,3,5",
            "4,3,7",
            "5,4,9",
            "0,9,10"
    })
    void test4(int x, int y,int expectSum) throws Exception {

        //when
        int sum = Calculator.add(x, y);

        //then
        assertThat(sum).isEqualTo(expectSum);
    }

    ////////////////////////////////////////////////////////////////////////////////////////////
    @DisplayName(
            "should return fullName of name end lastName "
    )
    @ParameterizedTest(name = "name:(0) and lastName(1): expect fullName (2)")
    @CsvSource({
            "Janusz,Kowalski,Janusz Kowalski",
            "Grażyna,Kowalska,Janusz Kowalski",
            "Zdzislaw,Nowak,Zdzislaw Nowak",
            "Zdzislaw,Nowak,ZdzislawNowak"
    })
    void test4(String name, String lastName,String fullName) throws Exception {

        //when
        String fullNameResult = name+" "+lastName;

        //then
        assertThat(fullName).isEqualTo(fullNameResult);
    }

}