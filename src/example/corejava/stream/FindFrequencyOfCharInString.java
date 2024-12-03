package example.corejava.stream;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindFrequencyOfCharInString {
    public static void main(String[] args) {
        String name = "yashwant";
        Map<Character, Long> freqMap =name.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("Frequency of char: " + freqMap);
    }
}
