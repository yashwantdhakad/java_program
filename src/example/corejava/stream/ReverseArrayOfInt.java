package example.corejava.stream;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ReverseArrayOfInt {
    public static void main(String[] args) {
        int[] arr = {2,1,2,3,5,3,4,6};

        String reverseOrder = Arrays.toString(IntStream.range(0, arr.length)
                .map(i -> arr[arr.length-1-i])
                .toArray());
        System.out.println("===reverseOrder==="+reverseOrder);
    }
}
