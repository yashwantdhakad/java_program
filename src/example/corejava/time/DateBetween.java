package example.corejava.time;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.util.List;

public class DateBetween {
    public static void main(String[] args) {
        LocalDate startDate = LocalDate.of(2011, 12, 12);
        LocalDate endDate = LocalDate.of(2024, 12, 26);

        long numDays = ChronoUnit.DAYS.between(startDate, endDate);
        System.out.println("Day between two dates: " + numDays);
        long numMonths = ChronoUnit.MONTHS.between(startDate, endDate);
        System.out.println("Month between two dates: " + numMonths);

        long numYears = ChronoUnit.YEARS.between(startDate, endDate);
        System.out.println("Years between two dates: " + numYears);

        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        list.parallelStream().forEach(System.out::println);

    }
}
