package example.corejava.string;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.stream.Collectors;

public class RemoveDuplicates {
    public static void main(String args[]) {
        String str = "programming";
        String distintString = Arrays.stream(str.split("")).distinct().collect(Collectors.joining());
        System.out.println("====distintString=="+distintString);
    }
}
