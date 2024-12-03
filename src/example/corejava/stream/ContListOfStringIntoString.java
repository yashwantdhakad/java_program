package example.corejava.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ContListOfStringIntoString {
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("Geeks", "for", "Geeks");
        // concatinate this list of string into string with , seperator using stream
        String stringJoin = stringList.stream().collect(Collectors.joining(","));
        System.out.println("String join: " + stringJoin);
    }
}
