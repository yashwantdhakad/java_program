package example.corejava.perci2;

import java.util.ArrayList;
import java.util.List;

public class RPNUsingList {
    private static int evaluateRPN(String[] expression) {
        List<Integer> list = new ArrayList<>();
        if (expression == null || expression.length == 0) {
            throw new IllegalArgumentException("Empty expression list");
        }
        for (String token: expression) {
            if (token == null || token.trim().isEmpty()) {
                throw new IllegalArgumentException("Invalid token.");
            }
            if ("+-*/".contains(token)) {
                int b = list.remove(list.size()-1);
                int a = list.remove(list.size()-1);
                list.add(operation(a,b, token));
            } else {
                list.add(Integer.parseInt(token));
            }
        }
        return list.getLast();
    }

    public static int operation(int a, int b, String op) {
        return switch (op) {
            case "+"-> a+b;
            case "-"-> a-b;
            case "*"-> a*b;
            case "/"-> a/b;
            default -> throw new IllegalStateException("Unexpected value: " + op);
        };
    }
    
    public static void main(String[] args) {
        String[] expression = {"2", "3", "+", "5", "*"};  // (2 + 3) * 5 = 25
        int result = evaluateRPN(expression);
        System.out.println("Result: " + result);
    }

}
