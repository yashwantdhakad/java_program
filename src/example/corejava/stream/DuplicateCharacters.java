package example.corejava.stream;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

// Find the duplicate characters in a string
public class DuplicateCharacters {

    public static void main(String[] args) {
        String str = "aabccdde";

        // Count the frequency of each character
        Map<Character, Long> characterCountMap = str.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(entry -> entry.getValue() > 1).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        System.out.println("Duplicate characters and their counts: " + characterCountMap);
    }
}
