package example.corejava.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// Convert List of String into Map and store String as key and length as value
public class ConvListOfStringIntoMap {
    public static void main(String[] args) {
        List<String> listOfStr = Arrays.asList("first", "second", "third", "fourth", "fifth");
        Map<String, Integer> stringToMap = listOfStr.stream().collect(Collectors.toMap(String::new, String::length));
        System.out.println(stringToMap);
    }
}
