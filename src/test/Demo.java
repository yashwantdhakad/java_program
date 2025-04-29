package test;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo {
    public static void main(String[] args) {
        // count the occurrence of each character in a string
        String name = "yashwant";
        Map<String, Long> countChar = Arrays.stream(name.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("=====countChar===="+countChar);
        // find all the duplicate characters from a string
        Map<String, Long> duplicateChar = countChar.entrySet().stream().filter(c -> c.getValue() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println("=====duplicate char==="+duplicateChar);
        // find the first non-repeating character from a string
        Optional<Map.Entry<String, Long>> findNonRepChar = Arrays.stream(name.split(""))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(e -> e.getValue() == 1)
                .collect(Collectors.toList()).stream().findFirst();
        System.out.println("=====findNonRepChar===="+findNonRepChar.get().getKey());
        // find second highest number from given array
        int arr[] = {1,2,3,6,5,4};
        Integer secondHighest = Arrays.stream(arr)
                .boxed().sorted(Comparator.reverseOrder())
                .collect(Collectors.toList()).stream().skip(1).findFirst().get();
        System.out.println("=====secondHighest===="+secondHighest);
        //find longest string from given list
        List<String> nameList = Arrays.asList("aman", "nameet", "rohit", "ankush", "yashwant");
        Optional<String> longestString = nameList.stream()
                .reduce((e1, e2) -> e1.length() > e2.length() ? e1 : e2);
        System.out.println("===longestString=="+longestString.get());
        // String.join example

        // Skip and limit example

        // Sort a list and map

        // map and flatMap example
    }
}
