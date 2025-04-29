package example;

import java.sql.Array;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String args[]) {
        List<String> list = Arrays.asList("first", "second", "third", "fourth", "fifth");

        String newString = list.stream().collect(Collectors.joining(", "));
        System.out.println("====new string ==="+newString);
        Map<String, Integer> map = list.stream().collect(Collectors.toMap(String::new, String::length));
        System.out.println("====map===="+map);

        Map<Integer, List<String>> collect = list.stream().collect(Collectors.groupingBy(String::length));
        System.out.println("======collect==="+collect);
        System.out.println("====key of map ==="+ collect.entrySet().stream().flatMap(entry->entry.getValue().stream()).collect(Collectors.toList()));

        int arr[] = {2,4,5,7,8};

        String str = Arrays.toString(IntStream.range(0, arr.length)
                .map(i-> arr[arr.length-1-i]).toArray());
        System.out.println("====str===="+str);

        List<Integer> listarry = Arrays.asList(2,4,5,6);
        List<Integer> collect1 = listarry.stream().mapToInt(Integer::valueOf).filter(i -> i > 2).boxed().collect(Collectors.toList());
        System.out.println("=====intStream==="+collect1);

        int[] arrOfInt = {1, 2, 2, 3, 4, 4, 5, 6, 7, 7, 8, 9, 10};
        Map<Integer, Long> mapOfduplicate = Arrays.stream(arrOfInt).boxed().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(i -> i.getValue() > 1).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println("===mapOfduplicate==="+mapOfduplicate);

        Integer min = Arrays.stream(arrOfInt).min().getAsInt();
        System.out.println("===min==="+min);

        int string = Arrays.stream(arrOfInt).max().getAsInt();
        System.out.println("====string==="+string);
    }
}
