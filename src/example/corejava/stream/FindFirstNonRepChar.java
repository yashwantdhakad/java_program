package example.corejava.stream;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

// Program to find the first non-repeating character from string.
public class FindFirstNonRepChar {
    public static void main(String[] args) {
        String name = "yashwant";
        Map<Character, Long> collectMap = name.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(c -> (char) c, LinkedHashMap::new, Collectors.counting()));
        Optional<Map.Entry<Character, Long>> first = collectMap.entrySet().stream().filter(entry -> entry.getValue() == 1).findFirst();
        System.out.println(first.get().getKey());

        Optional<Map.Entry<String, Long>> first1 = Arrays.stream(name.split("")).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(entry -> entry.getValue() == 1).findFirst();
        System.out.println("====collect===="+first1);
    }
}
