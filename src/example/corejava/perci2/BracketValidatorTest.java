package example.corejava.perci2;

import java.util.Stack;

public class BracketValidatorTest {

    public static boolean isValid(String input) {
        if (input == null) return false;

        if (input.isEmpty()) return true;

        Stack<Character> stack = new Stack<>();
        for (char ch: input.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) return true;
                char top = stack.pop();
                if (ch == ')' && top != '('
                        || ch == '}' && top != '{'
                        || ch == ']' && top != '[') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        test("()", true);
        test("()[]{}", true);
        test("(]", false);
        test("([])", true);
        test("{[()]}", true);
        test("([)]", false);
        test("((({{{[[[]]]}}})))", true);
        test("(", false);
        test("", true);
        test("([}}])", false);
        test("(){}[](){}[](){}[]", true);
        test("(){}[](){}[](){}[}", false);

        System.out.println("All tests completed.");
    }

    private static void test(String input, boolean expected) {
        boolean result = BracketValidatorTest.isValid(input);
        if (result == expected) {
            System.out.println("Passed for input: \"" + input + "\"");
        } else {
            System.out.println("Failed for input: \"" + input + "\" | Expected: " + expected + ", Got: " + result);
        }

    }
}