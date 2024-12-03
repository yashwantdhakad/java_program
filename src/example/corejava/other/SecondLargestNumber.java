package example.corejava.other;

import java.util.Arrays;

public class SecondLargestNumber {
    public static void main(String[] args) {
        Integer list[] = {1, 4, 3, 5, 8, 2, 9};

        int max = 0;
        int secondMax = 0;

        for (int i = 0; i < list.length; i++) {
            if (list[i] > max) {
                secondMax = max;
                max = list[i];
            } else if (list[i] > secondMax && list[i] != max) {
                secondMax = list[i];
            }
        }

        // find second largest number by stream api
        int secondLargest = Arrays.stream(list).sorted().skip(list.length - 2).findFirst().get();
        System.out.println("Second largest is: " + secondLargest);

        int secondLargestSort = Arrays.stream(list).sorted((a, b) -> b - a).skip(1).findFirst().get();
        System.out.println("Second largest second example is: " + secondLargestSort);

        System.out.println("Second large number is: " + secondMax);

    }
}
