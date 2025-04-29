package example.corejava;

import java.util.Arrays;
import java.util.List;

public class ExceptionInLambda {
    public static void main(String[] args) {
        List<String> nums = Arrays.asList("1", "2", "three");
        nums.forEach(s -> {
            try {
                System.out.println(Integer.parseInt(s));
            } catch (NumberFormatException e) {
                System.out.println(e);
            }
        });
    }
}
