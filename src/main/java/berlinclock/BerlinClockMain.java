package berlinclock;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class BerlinClockMain {
    public static void main(String[] args) throws InterruptedException {
        //Berlin clock on LocalTime Now
        while (true){
                System.out.println(BerlinClock.getFullTime(LocalTime.now())+ "    "+
                LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
                Thread.sleep(1000);
    }
    }
}
