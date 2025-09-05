package example.corejava.perci2;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class BalanceParenthesis {
    public static boolean isCorrectParenthesis(String input) {
        if (input.isEmpty()) {
            return false;
        }
        Set<Character> setOfBrackets = new HashSet<>(Arrays.asList('(', '{', '['));
        Stack<Character> stack = new Stack<>();
        for (char c: input.toCharArray()) {
            if (setOfBrackets.contains(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;

                char top = stack.pop();
                if (c == ']' && top != '['
                    || c == '}' && top != '{'
                    || c == ')' && top != '(') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        String s = "[{()}]";
        System.out.println("===parenthesis is balanced: " + isCorrectParenthesis(s));
    }
}
