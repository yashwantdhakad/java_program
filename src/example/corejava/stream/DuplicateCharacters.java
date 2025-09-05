package example.corejava.stream;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

// Find the duplicate characters in a string
public class DuplicateCharacters {

    public static void main(String[] args) {
        String str = "baacbccdde";

        // Count the frequency of each character
        Map<String, Long> collect1 = Arrays.stream(str.split("")).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
        System.out.println("====collect1==="+collect1);
        Map<String, Long> collect = Arrays.stream(str.split("")).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(entry -> entry.getValue() > 1).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));;
        System.out.println("====duplicate char are: ==="+collect);
    }
}
