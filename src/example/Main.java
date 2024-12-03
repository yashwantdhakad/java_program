package example;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Integer[] arr = {1,5,2,3,4,5,6,7,8};

        List<Integer> secondLargest = Arrays.stream(arr).sorted().collect(Collectors.toList());
        System.out.printf("Reverse list of arry: " + secondLargest);

        String s1 = new String("test");
        String s2 = "test";
        System.out.println("s1 string has code: " + s1.hashCode());
        System.out.println("s2 string has code: " + s2.hashCode());
    }

}