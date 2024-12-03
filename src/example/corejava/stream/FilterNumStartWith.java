package example.corejava.stream;

import java.util.Arrays;

public class FilterNumStartWith {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        Arrays.stream(arr).mapToObj(String::valueOf).filter(i -> i.startsWith("1")).forEach(System.out::println);

    }
}
