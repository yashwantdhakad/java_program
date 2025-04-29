package example.corejava;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ReverseFirstAndLastCharInString {
    public static void main(String[] args) {
        String str = "MMM LLL TTT";
        StringBuilder stringBuilder = new StringBuilder(str);
        stringBuilder.reverse();
        String collect = Arrays.stream(str.split(" ")).sorted(Comparator.reverseOrder()).collect(Collectors.joining(" "));
        System.out.println("====collect==="+collect);
        System.out.println("stringBuilder is: " + stringBuilder);
        String test = "name";
        // now reverse the string from stream
        String collect1 = IntStream.range(0, test.length())
                .mapToObj(i -> test.charAt(test.length() - 1 - i))
                .map(String::valueOf)
                .collect(Collectors.joining());
        System.out.println("====collect1==="+collect1);


    }
}
