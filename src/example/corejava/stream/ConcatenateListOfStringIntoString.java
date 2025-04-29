package example.corejava.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

// Concatenate list of string into string and join with ,
public class ConcatenateListOfStringIntoString {
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("Geeks", "for", "Geeks");
        // concatenate this list of string into string with , separator using stream
        String stringJoin = stringList.stream().collect(Collectors.joining(","));
        System.out.println("String join: " + stringJoin);
    }
}
