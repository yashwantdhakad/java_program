package example.corejava.stream;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.stream.Collectors;

public class SumEvenOddNum {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        IntSummaryStatistics sumOfEven = Arrays.stream(arr).mapToObj(Integer::valueOf).collect(Collectors.summarizingInt(i-> i % 2 == 0 ? i : 0));
        System.out.println("Sum of even numbers: " + sumOfEven.getSum());

        IntSummaryStatistics sumOfOdd = Arrays.stream(arr).mapToObj(Integer::valueOf).collect(Collectors.summarizingInt(i -> i % 2 != 0 ? i : 0));
        System.out.println("Sum of odd numbers: " + sumOfOdd.getSum());
    }
}
