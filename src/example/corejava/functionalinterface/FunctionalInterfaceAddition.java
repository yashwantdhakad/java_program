package example.corejava.functionalinterface;

@FunctionalInterface
interface Addition {
    int add(int a, int b);
}

public class FunctionalInterfaceAddition {
    public static void main(String[] args) {
        Addition addition = (a, b) -> a + b;

        int result = addition.add(2, 5);
        System.out.println("Sum of two numbers : " + result);
    }
}
