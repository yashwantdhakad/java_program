package example.corejava.perci2;

import java.util.Stack;

public class PrefixAnnotation {
    public static int evalPrefixNotation(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = tokens.length-1; i>=0; i--) {
            String token = tokens[i];
            if ("+-*/".contains(token)) {
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
            case "/" -> {
                if (b ==0) throw new ArithmeticException("Division by zero");
                yield a/b;
            }
            default -> throw new IllegalArgumentException("Invalid operator.");
        };
    }
    public static void main(String[] args) {
        String[] expr = {"+", "2", "*", "3", "4"}; // 2 + (3 * 4) = 14
        System.out.println("====prefix operation :" + evalPrefixNotation(expr));
    }
}
