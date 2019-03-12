package berlinclock;

import java.time.LocalTime;

public class BerlinClockMain {
    public static void main(String[] args) throws InterruptedException {
        //Berlin clock on LocalTime Now
        while (true){
        System.out.println(BerlinClock.getFullTime(LocalTime.now())+"    "+LocalTime.now());
        Thread.sleep(1000);
    }
    }
}
