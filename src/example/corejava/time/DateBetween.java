package example.corejava.time;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

public class DateBetween {
    public static void main(String[] args) {
        LocalDate startDate = LocalDate.of(2024, 8, 1);
        LocalDate endDate = LocalDate.of(2024, 8, 15);

        long numDays = ChronoUnit.DAYS.between(startDate, endDate);
        System.out.println("Day between two dates: " + numDays);
    }
}
