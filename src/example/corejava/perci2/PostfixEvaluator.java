package example.corejava.perci2;

import java.util.Stack;

public class PostfixEvaluator {
    public static int evaluatePostFix(String str) {
        Stack<Integer> stack = new Stack<>();
        for (String s : str.split("\\s+")) {
            if (s.matches("-?\\d+")) {
                stack.push(Integer.parseInt(s));
            } else {
                int b = stack.pop();
                int a = stack.pop();
                int result = applyOperator(a, b, s);
                stack.push(result);
            }
        }

        return stack.pop();
    }

    public static int applyOperator(int a, int b, String op) {
        return switch (op) {
            case "+" -> a+b;
            case "-" -> a-b;
            case "*" -> a*b;
            case "/" -> {
                if (b ==0) throw new ArithmeticException("Division by zero");
                yield a/b;
            }
            default -> throw new IllegalArgumentException("Invalid operator");
        };
    }

    public static void main(String[] args) {
        String s = "5 1 2 + 4 * + 3 -";
        System.out.println("===postfix operation: " + evaluatePostFix(s));
    }
}
