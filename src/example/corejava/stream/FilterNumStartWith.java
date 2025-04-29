package example.corejava.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilterNumStartWith {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        List<String> stringStream = Arrays.stream(arr).mapToObj(String::valueOf).filter(i -> i.startsWith("1")).collect(Collectors.toList());
        System.out.println("Numbers starting with 1: " + stringStream);
    }
}
