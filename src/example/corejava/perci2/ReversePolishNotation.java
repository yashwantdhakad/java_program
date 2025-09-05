package example.corejava.perci2;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Set;

public class ReversePolishNotation {
    private static final Set<String> OPERATORS = Set.of("+", "-", "*", "/");


    public static int reversePolishNotation(String[] strings) {
        if (strings == null || strings.length == 0) throw new IllegalArgumentException("Empty string");

        Deque<Integer> stack = new ArrayDeque<>();
        for (String token: strings) {
            if (token.isEmpty()) throw new IllegalArgumentException("Empty token");
            if (OPERATORS.contains(token)) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(operation(a, b, token));
            } else {
                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }

    public static int operation(int a, int b, String op) {
        return switch (op) {
            case "+" -> a+b;
            case "-" -> a-b;
            case "*" -> a*b;
            case "/" -> a/b;
            default -> throw new IllegalArgumentException("");
        };
    }


    public static void main(String[] args) {
        String[] str = {"2","1","+","3","*"};
        System.out.println("====output: " + reversePolishNotation(str));

        String[] str1 = {"2","2","+","3","*"};
        System.out.println("====output: " + reversePolishNotation(str1));
    }
}
