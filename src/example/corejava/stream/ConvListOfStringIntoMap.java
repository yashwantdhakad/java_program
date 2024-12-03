package example.corejava.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ConvListOfStringIntoMap {
    public static void main(String[] args) {
        List<String> listOfStr = Arrays.asList("first", "second", "third", "fourth", "fifth");
        Map<String, Integer> stringToMap = listOfStr.stream().collect(Collectors.toMap(String::new, String::length));
        System.out.println(stringToMap);
    }
}
