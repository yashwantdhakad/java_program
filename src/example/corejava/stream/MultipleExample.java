package example.corejava.stream;

import example.Main;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MultipleExample {
    public static void main(String args[]) {
        // programming interview questions
        // 1. Find the first non-repetitive character in a string
        String name = "yashwant";
        Map<Character, Long> collect = name.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
        Optional<Map.Entry<Character, Long>> nonRepetativeCharMap = collect.entrySet().stream().filter(entry -> entry.getValue() == 1).findFirst();
        // System.out.println("====nonRepetativeCharMap==="+nonRepetativeCharMap.get());
        // 2. Remove all the occurrence of a character in a string
        String str = "Geeks of Geeks";
        String newStringWithRemoveChar = str.chars().filter(c -> c != 'e').mapToObj(c -> String.valueOf((char) c)).collect(Collectors.joining());
//        System.out.println("=====newStringWithRemoveChar==="+newStringWithRemoveChar);
        String newStringWithReplaceChar = str.chars().map(c -> c == 'e' ? 'x' : c).mapToObj(c -> String.valueOf((char) c)).collect(Collectors.joining());
//        System.out.println("====newStringWithReplaceChar==="+newStringWithReplaceChar);
        // 3. Sum of even and odd number in given list of integer number
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        double sumOfSqrt = numbers.stream().mapToDouble(Math::sqrt).sum();
//        System.out.println("=====sumOfSqrt==="+sumOfSqrt);
        int sumOfEven = numbers.stream().filter(n -> n % 2 == 0).mapToInt(Integer::intValue).sum();
        // System.out.println("====sumOfEven==="+sumOfEven);
        int sumOfOdd = numbers.stream().filter(n -> n % 2 != 0).mapToInt(Integer::intValue).sum();
        // System.out.println("=====sumOfOdd==="+sumOfOdd);
        Double average = numbers.stream().mapToInt(Integer::intValue).average().getAsDouble();
//        System.out.println("===average==="+average);
        OptionalInt min = numbers.stream().mapToInt(Integer::intValue).min();
        OptionalInt max = numbers.stream().mapToInt(Integer::intValue).max();
        // 4. Sort the list of string in reverse order
        List<String> names = Arrays.asList("Aman", "yashwant", "Rohit");
        List<String> sortedList = names.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        // System.out.println("=====sortedList==="+sortedList);
        // 5. Convert list of string into map key is the string and value as length
        List<String> cities = Arrays.asList("indore", "bhopal", "pune", "banglore");
        Map<Integer, List<String>> stringToMap = cities.stream().collect(Collectors.groupingBy(String::length));
        // System.out.println("====stringToMap===="+stringToMap);
        Map<String, Integer> strinMap = cities.stream().collect(Collectors.toMap(s -> s, String::length));
        // System.out.println("====strinMap==="+strinMap);
        // 6. Find the duplicate characters in string
        String nameStr = "yashwantdhakad";
        Map<Character, Long> nameCharMap = nameStr.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<Character, Long> duplicateCharMap = nameCharMap.entrySet().stream().filter(entry -> entry.getValue() > 1).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        // System.out.println("===duplicateCharMap==="+duplicateCharMap);
        // 7. Flatten list of list into list
        List<List<String>> listOfList = Arrays.asList(
                Arrays.asList("Software", "IT", "Machanical"),
                Arrays.asList("Pune", "banglore", "Indore")
        );
        List<String> listOfItems = listOfList.stream().flatMap(s -> s.stream()).collect(Collectors.toList());
        // System.out.println("====listOfItems==" + listOfItems);
        // 8. Filter the list of number start with 1
        List<Integer> numberList = Arrays.asList(1,2,3,4,5,6,7,11,21,12);
        List<String> listStartWith1 = numberList.stream().map(i -> String.valueOf(i)).filter(i -> i.startsWith("1")).collect(Collectors.toList());
        System.out.println("====listStartWith1==="+listStartWith1);
        // 9. Joining the list of string into string
        List<String> list = Arrays.asList("yashwant", "aman", "rohit");
        String stringFromList = list.stream().collect(Collectors.joining(", "));
        // System.out.println("===stringFromList===" + stringFromList);
    }
}
