package example;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Test {
    public static void main(String[] args) {

        int[] arr = {1,3,2,6,5,8,7};
        String reverseOrderArry = Arrays.toString(IntStream.range(0, arr.length).map(i -> arr[arr.length - 1 - i]).toArray());
        System.out.println("=====reverseOrderArry==="+reverseOrderArry);
        // String immutable example
        String name = "Yashwant";
        name.concat(" dhakad");
        System.out.println("============name======"+name);
        // Output is: ============name======Yashwant

        // Joining the list of string into string
        List<String> names = Arrays.asList("Aman", "yashwant", "Rohit");
        String collect = String.join(", ", names);
        String collectFromStream = names.stream().collect(Collectors.joining(", "));
        System.out.println("====collect====="+collect);
        // Output is:====collect=====Aman, yashwant, Rohit


        // Convert list of string into map key is the string and value as length
        Map<String, Integer> stringMap = names.stream().collect(Collectors.toMap(String::new, String::length));
        System.out.println("=======stringMap====="+stringMap);
        // Output is:=======stringMap====={Rohit=5, yashwant=8, Aman=4}

        // Find the duplicate characters in string
        Map<Character, Long> charMap = name.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<Character, Long> uniqueMap = charMap.entrySet().stream().filter(map -> map.getValue() > 1).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println("====charMap======"+charMap);
        System.out.println("====uniqueMap==="+uniqueMap);
        // Output is: ====charMap======{a=2, s=1, t=1, w=1, h=1, Y=1, n=1}
        //            ====uniqueMap==={a=2}


        // Filter the list of number start with 1
        int numbers[] = {10, 20, 30, 11, 12};
        List<String> numberList = Arrays.stream(numbers).mapToObj(String::valueOf).filter(s -> s.startsWith("1")).collect(Collectors.toList());
        System.out.println("========numberList=="+numberList);
        // Output is: ========numberList==[10, 11, 12]
        Double average = Arrays.stream(numbers).average().getAsDouble();
        System.out.println("=====average==="+average);
        int maxNumber = Arrays.stream(numbers).max().getAsInt();
        System.out.println("====maxNumber==="+maxNumber);

        // Flatten list of list into list
        List<List<String>> list = Arrays.asList(
            Arrays.asList("aman", "naman", "ankit"),
            Arrays.asList("suresh", "prabhu"),
            Arrays.asList("yashwant", "lokesh")
        );
        List<String> flatMapList = list.stream().flatMap(Collection::stream).collect(Collectors.toList());
        System.out.println("=======flatMapList========"+flatMapList);
        // Output is:
        //=======flatMapList========[aman, naman, ankit, suresh, prabhu, yashwant, lokesh]

        // Find the first non-repetitive character from string
        String test = "mynameisyash";
        LinkedHashMap<Character, Integer> findFirstNonRepChar = test.chars().mapToObj(c -> (char) c).collect(Collectors.toMap(c -> c, c -> 1, Integer::sum, LinkedHashMap::new));
        System.out.println("====findFirstNonRepChar==="+findFirstNonRepChar);
        Character firstChar = findFirstNonRepChar.entrySet().stream().filter(map -> map.getValue() == 1).findFirst().get().getKey();
        System.out.println("Non rep char is: " + firstChar);
        // Output is:
        // ====findFirstNonRepChar==={m=2, y=2, n=1, a=2, e=1, i=1, s=2, h=1}
        // Non rep char is: n

        String str = "geeks for geeks";
        char ch = 'e';
        // Remove all the occurrence of ch in string
        // if we need to change with other character then use this char
        char repChar = 'x';
        String charReplaceString = str.chars().mapToObj(c -> c == ch ? String.valueOf(repChar) : String.valueOf((char) c))
                .collect(Collectors.joining());
        System.out.println("======charReplaceString====="+charReplaceString);

        // Sum of even and odd number in given list of integer number
        int num[] = {1,2,3,4,5,6,7,8,9};
        IntSummaryStatistics intSumEven = Arrays.stream(num).boxed().filter(n -> n % 2 == 0).collect(Collectors.summarizingInt(n -> n));
        System.out.println("====intSumEven===="+intSumEven.getSum());
        IntSummaryStatistics intSumOdd = Arrays.stream(num).boxed().filter(n -> n % 2 != 0).collect(Collectors.summarizingInt(n -> n));
        System.out.println("====intSumOdd===="+intSumOdd.getSum());
        // Output is: ====intSumEven====20
        //            ====intSumOdd====25

        // sorted the list of string in reverse order
        List<String> sortedList = names.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println("=====order list==="+ sortedList);

        // Lambda expression example
        names.forEach(System.out::println);

        // programming interview questions
        // 1. Find the first non-repetitive character in a string
        // 2. Remove all the occurrence of a character in a string
        // 3. Sum of even and odd number in given list of integer number
        // 4. Sort the list of string in reverse order
        // 5. Convert list of string into map key is the string and value as length
        // 6. Find the duplicate characters in string
        // 7. Flatten list of list into list
        // 8. Filter the list of number start with 1
        // 9. Joining the list of string into string
        // 10.
    }
}