package example.corejava.other;

import java.time.LocalDate;

public class LocalDateExample {

    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        System.out.println("Now date:" + now);
        LocalDate customDate = LocalDate.of(2026,1,31);
        if (customDate.isAfter(now)) {
            System.out.println("Date is after the current date");
        } else {
            System.out.println("Date is before the current date");
        }
    }
}
