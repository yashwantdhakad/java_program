package example.corejava.other;

public class FactorialExample {
    public static int fact(int number) {
        int factorial = 1;
        if (number > 1) {
            factorial = number * fact(number - 1);
        } else {
            return 1;
        }
        return factorial;
    }

    public static void main(String[] args) {
        int n = 6;
        int fact = fact(n);
        System.out.println("Factorial of number" + n + "is : " + fact);
    }
}
