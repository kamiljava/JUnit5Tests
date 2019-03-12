package berlinclock;

import java.time.LocalTime;

public class BerlinClock {

    public static String getSecond(LocalTime localTime) {
        return localTime.getSecond() % 2 == 0 ? "R" : "O";
    }

    public static String getSingleMinutes(LocalTime localTime) {
        return getRowWithAnyLamps(localTime.getMinute() % 5, "Y", 4);
    }

    public static String getSingleHours(LocalTime localTime) {
        return getRowWithAnyLamps(localTime.getHour() % 5, "R", 4);
    }

    public static String getFiveHours(LocalTime localTime) {
        return getRowWithAnyLamps(localTime.getHour() / 5, "R", 4);
    }

    private static String getRowWithAnyLamps(int numberOfLampsToLight, String colorLamp, int numberOfLampsInRow) {
        StringBuilder lampsRow = new StringBuilder();
        for (int i = 0; i < numberOfLampsToLight; i++) {
            lampsRow.append(colorLamp);
        }
        for (int i = numberOfLampsToLight; i < numberOfLampsInRow; i++) {
            lampsRow.append("O");
        }
        return lampsRow.toString();
    }

    public static String getFiveMinutes(LocalTime localTime) {
        String lampsRow = getRowWithAnyLamps(localTime.getMinute() / 5, "Y", 11);
        return lampsRow.toString().replace("YYY", "YYR");
    }

    public static String getFullTime(LocalTime localTime) {
        return String.format("%s|%s|%s|%s|%s", getSecond(localTime), getFiveHours(localTime), getSingleHours(localTime), getFiveMinutes(localTime), getSingleMinutes(localTime));
    }
}
