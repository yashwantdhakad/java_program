package example.corejava.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupListOfStringByLength {
    public static void main(String[] args) {
        List<String> listStr = Arrays.asList("first", "second", "third", "fourth", "fifth");
        Map<Integer, List<String>> listMap = listStr.stream().collect(Collectors.groupingBy(String::length));
        System.out.println("Group by length: " + listMap);
    }
}
