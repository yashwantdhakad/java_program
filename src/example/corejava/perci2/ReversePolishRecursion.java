package example.corejava.perci2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ReversePolishRecursion {
    public static int dfs(List<String> tokens) {
        String token = tokens.removeLast();
        if (!"+-*/".contains(token)) {
            return Integer.parseInt(token);
        }

        int b = dfs(tokens);
        int a = dfs(tokens);

        return switch (token) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> {
                if (b == 0) throw new IllegalArgumentException("Division by zero.");
                yield a / b;
            }
            default -> throw new IllegalArgumentException("Invalid token: " + token);
        };
    }

    public static void main(String[] args) {
        String[] str = {"2", "1", "3", "+", "*", "3", "*"};
        List<String> list = new ArrayList<>(Arrays.asList(str));
        System.out.println("====output: " + dfs(list));

        String[] str1 = {"2", "2", "+", "3", "*"};
        List<String> list1 = new ArrayList<>(Arrays.asList(str1));
        System.out.println("====output: " + dfs(list1));
    }
}
