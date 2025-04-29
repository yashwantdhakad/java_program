package example.corejava.other;

import com.sun.xml.internal.fastinfoset.util.CharArray;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class ReverseNumberExample {
    public static void main(String[] args) {
        int n=123456, sum = 0, temp = 0;
        while (n > 0) {
            temp = n % 10;
            sum = (sum * 10) + temp;
            n = n / 10;
        }
        System.out.println("Reverse number is: " + sum);

        int[] arr = new int[]{n};
        System.out.println("=====arr===="+arr);
        String string = Arrays.toString(IntStream.range(0, arr.length).map(i -> arr[arr.length - i - 1]).toArray());
        System.out.println("====string==="+string);
    }
}
