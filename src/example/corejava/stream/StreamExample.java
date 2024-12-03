package example.corejava.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExample {
    public static void main(String[] args) {
        List<String> myList = Arrays.asList("a1", "a2", "a3", "b1", "b2", "c2", "c1");
        // filter the list which start with c
        myList.stream().filter(s-> s.startsWith("c")).collect(Collectors.toList()).forEach(System.out::println);
        // Convert the list of string into upper case
        myList.stream().map(String::toUpperCase).collect(Collectors.toList()).forEach(System.out::println);
//        myList.stream().distinct().collect(Collectors.toList()).forEach(System.out::println);
//        myList.stream().sorted().collect(Collectors.toList()).forEach(System.out::println);
//        myList.stream().peek(System.out::println).collect(Collectors.toList());
//        myList.stream().limit(3).collect(Collectors.toList()).forEach(System.out::println);
//        myList.stream().skip(3).collect(Collectors.toList()).forEach(System.out::println);
//        myList.stream().forEachOrdered(System.out::println);
        myList.stream().reduce((a, b) -> a + "," + b).ifPresent(System.out::println);
//        System.out.println(myList.stream().count());

//        List<List<String>> nestedList = Arrays.asList(
//                Arrays.asList("a1", "a2"),
//                Arrays.asList("b1", "b2"),
//                Arrays.asList("c2", "c1")
//        );
//        nestedList.stream()
//                .flatMap(List::stream)
//                .collect(Collectors.toList()).forEach(System.out::println);

        myList.stream().collect(Collectors.groupingBy(s-> s.substring(0,1))).forEach((key, value) -> System.out.println(key + " " + value));
//        System.out.println(myList.stream()
//                .min(Comparator.naturalOrder())
//                .orElse("none"));
//        System.out.println(myList.stream()
//                .max(Comparator.naturalOrder())
//                .orElse("none"));
        myList.stream()
                .collect(Collectors.partitioningBy(s -> s.startsWith("a"))).forEach((key, value) -> System.out.println(key + " " + value));

        // Average of number in list
        List<Integer> nums = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        Double average = nums.stream().mapToDouble(Integer::doubleValue).average().orElse(0.0);
        System.out.println("average is :" +average);

        // Upper case example in list of string
        List<String> strings = Arrays.asList("red", "green", "blue", "white");
        List<String> upperCareStr = strings.stream().map(String:: toUpperCase).collect(Collectors.toList());
        System.out.println("Upper case string :"+upperCareStr);

        // Sum of even and odd num
        List<Integer> numList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Double sumOfEvenNo = numList.stream().filter(n -> n % 2 == 0).mapToDouble(Integer::doubleValue).sum();
        System.out.println("Sum of even no: " + sumOfEvenNo);
        Double sumOfOddNo = numList.stream().filter(n -> n % 2 != 0).mapToDouble(Integer::doubleValue).sum();
        System.out.println("Sum of odd no: " + sumOfOddNo);

        // Remove the duplicate nums from list
        List<Integer> duplicateNums = Arrays.asList(1, 1, 2, 2, 3, 3, 4, 5, 5, 6, 7, 7, 8, 9, 10);
        System.out.println("Orignal List: " + duplicateNums);
        List<Integer> uniqueNums = duplicateNums.stream().distinct().collect(Collectors.toList());
        System.out.println("Unique list: " + uniqueNums);

        // Sort list of string in ascending and desc order
        List<String> colors = Arrays.asList("Red", "Green", "Blue", "Pink", "Brown");
        List<String> ascendingOrderList = colors.stream().sorted().collect(Collectors.toList());
        System.out.println("Ascending order list: " + ascendingOrderList);
        List<String> descOrderList = colors.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println("Desc order list: " +descOrderList);

        // Find the min and max num in list
        List<Integer> minMaxNums = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        System.out.println("Orignal list: " + minMaxNums);
        Integer minNum = minMaxNums.stream().min(Integer::compare).orElse(null);
        System.out.println("Min num is: " + minNum);
        Integer maxNum = minMaxNums.stream().max(Integer::compare).orElse(null);
        System.out.println("Max num is: " + maxNum);

        // Find second largest and smallest nums from list
        List<Integer> unsortedList = Arrays.asList(1,5,6, 2, 3, 4, 7, 8, 9);
        System.out.println("Original list: " + unsortedList);
        List<Integer> sortedList = unsortedList.stream().sorted().collect(Collectors.toList());
        System.out.println("Sorted order list:"+sortedList);
        Integer secondSmallest = sortedList.stream().skip(1).findFirst().orElse(null);
        System.out.println("Second smallest num:" + secondSmallest);
        List<Integer> reverseOrderSort = unsortedList.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        System.out.println("Reverse order list:" +reverseOrderSort);
        Integer secondLargest = reverseOrderSort.stream().skip(1).findFirst().orElse(null);
        System.out.println("Second largest num:"+ secondLargest);
    }
}
