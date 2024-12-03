package example.persistent.stringproblem;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DuplicateStringInList {
    public static boolean findDuplicate(List<String> list) {
        Set<String> unique = new HashSet<>();
        for(String str: list) {
            if (unique.contains(str)) {
                return true;
            } else {
                unique.add(str);
            }
        }
        return false;
    }
    public static Map<String, Integer> countFrequencies(List<String> list) {
        Map<String, Integer> map = new HashMap<>();
        for (String temp: list) {
            if (map.containsKey(temp)) {
                map.put(temp, map.getOrDefault(temp, 0) + 1);
            } else {
                map.put(temp, 1);
            }
        }
        return map;
    }

    public static void main (String[] args) {
        List<String> listOfString = Arrays.asList("abc", "bcd", "abc");
        Map<String, Long> newMap = listOfString.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("Map from stream: "+ newMap);
        System.out.println("Find Duplicate:" + findDuplicate(listOfString));
        System.out.println("Find Duplicate map:" + countFrequencies(listOfString));

        Map<String, Long> streamMap = listOfString.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("Find Duplicate Map from stream: "+ streamMap);
    }
}
