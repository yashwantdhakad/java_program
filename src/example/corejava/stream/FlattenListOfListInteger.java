package example.corejava.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FlattenListOfListInteger {
    public static void main(String[] args) {
        List<List<Integer>> intList = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6),
                Arrays.asList(7, 8, 9)
        );
        List<Integer> flatList = intList.stream().flatMap(list -> list.stream()).collect(Collectors.toList());
        System.out.println(flatList);
    }
}
