package example.corejava.other;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class SecondLargestNumber {
    public static void main(String[] args) {
        Integer[] list = {1, 4, 3, 5, 8, 2, 9};

        int max = 0;
        int secondMax = 0;
        System.out.println("==length===="+list.length);

        for (int i = 0; i < list.length; i++) {
            System.out.println("=====list=====" + list[i]);
            if (list[i] > max) {
                secondMax = max;
                max = list[i];
            } else if (list[i] > secondMax && list[i] != max) {
                secondMax = list[i];
            }
        }
        System.out.println("Second large number from custom logic: " + secondMax);

        // find second largest number by stream api
        int secondLargest = Arrays.stream(list).sorted().skip(list.length - 2).findFirst().get();
        System.out.println("Second largest is: " + secondLargest);

        int secondLargestSort = Arrays.stream(list).sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
        System.out.println("Second largest second example is: " + secondLargestSort);

        Arrays.stream(list).sorted().toList().stream().skip(1).findFirst().ifPresent(System.out::println);

    }
}
