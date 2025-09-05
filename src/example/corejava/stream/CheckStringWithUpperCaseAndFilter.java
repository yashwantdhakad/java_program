package example.corejava.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CheckStringWithUpperCaseAndFilter {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Aman Mishra", "Yashwant Dhakad", "ankush upadhaya");
        String collect = names.stream().filter(s -> s.chars().anyMatch(Character::isUpperCase)).collect(Collectors.joining(","));
        System.out.println("====collect ==="+collect);
    }
}
