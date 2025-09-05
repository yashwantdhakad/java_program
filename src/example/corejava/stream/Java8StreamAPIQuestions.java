package example.corejava.stream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Java8StreamAPIQuestions {
    public static void main(String args[]) {
        // count the occurrence of each character in a string
        String name = "yashwantdhakad";
        Map<String, Long> charMap = Arrays.stream(name.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println("====charMap==="+charMap);
        // find all the duplicate characters from a string
        List<Map.Entry<String, Long>> duplicateCharacters = Arrays.stream(name.split(""))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .filter(m -> m.getValue() > 1)
                .toList();
        System.out.println("======duplicateCharacters==="+duplicateCharacters);

        // find the first non-repeating character from a string
        String key = Arrays.stream(name.split(""))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(s -> s.getValue() == 1)
                .findFirst().get().getKey();
        System.out.println("====key===="+key);
        // find second highest number from given array
        int[] numbers = {1,2,3,4,5,6,2,1,44,5,66,66};
        int min = Arrays.stream(numbers).min().getAsInt();
        System.out.println("Min:" +min);
        int max = Arrays.stream(numbers).max().getAsInt();
        System.out.println("Max:" + max);
        Integer secondLargestNumber = Arrays.stream(numbers).boxed()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst().get();
        System.out.println("======secondLargestNumber=="+secondLargestNumber);
        List<Integer> reversedArray = Arrays.stream(numbers).boxed().collect(Collectors.toList()).reversed();
        System.out.println("====reversedArray==="+reversedArray);
        //find longest string from given list
        List<String> list = Arrays.asList("aman", "yashwant", "rohit", "nameet");
        String longString = list.stream().reduce((s1, s2) -> s1.length() > s2.length() ? s1 : s2).get();
        System.out.println("===longString=="+longString);
        // String.join example
        String[] nameList = {"aman", "yashwant", "rohit", "nameet"};
        String joinString = String.join(",", nameList);
        System.out.println("====joinString==="+joinString);
        // Skip and limit example
        int[] numArray = {1,2,3,4,5,6,7,7,8,9};
        List<Integer> skipAndLimit = Arrays.stream(numArray)
                .boxed()
                .skip(2)
                .limit(2)
                .toList();
        System.out.println("====skipAndLimit==="+skipAndLimit);
        // Sort a list and map
        List<String> sortedList = Arrays.stream(nameList)
                .sorted(Comparator.reverseOrder())
                .toList();
        System.out.println("===sortedList==="+sortedList);
        // map and flatMap example
//        int a = 5;
//        int b =0;
//        try {
//            int temp = a/b;
//        } catch (NumberFormatException e) {
//            System.out.println("division by zero");
//        }

        List<String> names = Arrays.asList("yashwant", "aman", "rohit", "aman");
        Map<String, Long> collect = names.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println("====collect==="+collect);

        String nameString = "yasyhwant";
        Map<String, Long> collect1 = Arrays.stream(nameString.split("")).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream().filter(entry -> entry.getValue() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println("=====collect1==="+collect1);
    }
}
