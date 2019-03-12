package berlinclock;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalTime;

public class BerlinClockTest {
    // @formatter:off
    @DisplayName(
            "given time, then seconds lamp blinks only when second is even"
    )
    @ParameterizedTest(name="given time: {0}, lamp blink: {1}")
    @CsvSource({
            " '00:00:00','R' ",
            " '00:00:01','O' "
    })
    // @formatter:on
    public void test(LocalTime localTime, String expectedLamp) {
        //when
        String lampSecond = BerlinClock.getSecond(localTime);
        //then
        Assertions.assertThat(lampSecond).isEqualTo(expectedLamp);
    }


    // @formatter:off
    @DisplayName(
            "given time, then single minutes row blinks as in following examples."
    )
    @ParameterizedTest(name="given time: {0}, expected single minutes row: {1}")
    @CsvSource({
            " '00:00:00','OOOO' ",
            " '00:01:00','YOOO' ",
            " '00:02:00','YYOO' ",
            " '00:03:00','YYYO' ",
            " '00:04:00','YYYY' ",
            " '00:05:00','OOOO' ",
            " '00:06:00','YOOO' "

    })
    // @formatter:on
    public void test1(LocalTime localTime, String expectedRow) {
        //when
        String singleMinutesRow = BerlinClock.getSingleMinutes(localTime);
        //then
        Assertions.assertThat(singleMinutesRow).isEqualTo(expectedRow);
    }

    // @formatter:off
    @DisplayName(
            "given time, then single hours row blinks as in following examples."
    )
    @ParameterizedTest(name="given time: {0}, expected single hours row: {1}")
    @CsvSource({
            " '00:00:00','OOOO' ",
            " '01:00:00','ROOO' ",
            " '02:00:00','RROO' ",
            " '03:00:00','RRRO' ",
            " '04:00:00','RRRR' ",
            " '05:00:00','OOOO' ",
            " '06:00:00','ROOO' ",
    })
    // @formatter:on
    public void test2(LocalTime localTime, String expectedRow) {
        //when
        String singleHoursRow = BerlinClock.getSingleHours(localTime);
        //then
        Assertions.assertThat(singleHoursRow).isEqualTo(expectedRow);
    }

    // @formatter:off
    @DisplayName(
            "given time, then 5 hours row blinks as in following examples."
    )
    @ParameterizedTest(name="given time: {0}, expected 5 hours row: {1}")
    @CsvSource({
            " '00:00:00','OOOO' ",
            " '05:00:00','ROOO' ",
            " '10:00:00','RROO' ",
            " '11:00:00','RROO' ",
            " '14:00:00','RROO' ",
            " '15:00:00','RRRO' ",
            " '20:00:00','RRRR' "
 })
    // @formatter:on
    public void test3(LocalTime localTime, String expectedRow) {
        //when
        String fiveHoursRow = BerlinClock.getFiveHours(localTime);
        //then
        Assertions.assertThat(fiveHoursRow).isEqualTo(expectedRow);
    }


    // @formatter:off
    @DisplayName(
            "given time, then 5 minutes row blinks as in following examples."
    )
    @ParameterizedTest(name="given time: {0}, expected 5 minutes row: {1}")
    @CsvSource({
            " '00:00:00','OOOOOOOOOOO' ",
            " '00:05:00','YOOOOOOOOOO' ",
            " '00:06:00','YOOOOOOOOOO' ",
            " '00:10:00','YYOOOOOOOOO' ",
            " '00:15:00','YYROOOOOOOO' ",
            " '00:20:00','YYRYOOOOOOO' ",
            " '00:25:00','YYRYYOOOOOO' ",
            " '00:30:00','YYRYYROOOOO' ",
            " '00:35:00','YYRYYRYOOOO' ",
            " '00:40:00','YYRYYRYYOOO' ",
            " '00:45:00','YYRYYRYYROO' ",
            " '00:50:00','YYRYYRYYRYO' ",
            " '00:55:00','YYRYYRYYRYY' ",
            " '00:59:00','YYRYYRYYRYY' ",

 })
    // @formatter:on
    public void test4(LocalTime localTime, String expectedRow) {
        //when
        String fiveMinutesRow = BerlinClock.getFiveMinutes(localTime);
        //then
        Assertions.assertThat(fiveMinutesRow).isEqualTo(expectedRow);
    }


    // @formatter:off
    @DisplayName(
            "given time, then show full rows in Berlin clock format 'second|five_hours|single_hours|five_minutes|single_minutes'"
    )
    @ParameterizedTest(name="given time: {0}, expected full time: {1}")
    @CsvSource({
            " '00:00:00','R|OOOO|OOOO|OOOOOOOOOOO|OOOO' ",
            " '11:24:01','O|RROO|ROOO|YYRYOOOOOOO|YYYY' "

 })
    // @formatter:on
    public void test5(LocalTime localTime, String expectedRow) {
        //when
        String fullTime = BerlinClock.getFullTime(localTime);
        //then
        Assertions.assertThat(fullTime).isEqualTo(expectedRow);
    }

}
