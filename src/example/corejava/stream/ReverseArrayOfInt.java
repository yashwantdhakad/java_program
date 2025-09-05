package example.corejava.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ReverseArrayOfInt {
    public static void main(String[] args) {
        int[] arr = {2,1,2,3,5,3,4,6};
        List<Integer> test = Arrays.asList(1, 2);

        String reverseOrder = Arrays.toString(IntStream.range(0, arr.length)
                .map(i -> arr[arr.length-1-i])
                .toArray());
        System.out.println("===reverseOrder==="+reverseOrder);

        List<Integer> reversed = Arrays.stream(arr)
                .boxed().collect(Collectors.toList())
                .reversed();
        System.out.println("Reversed array: " + reversed);
    }
}
