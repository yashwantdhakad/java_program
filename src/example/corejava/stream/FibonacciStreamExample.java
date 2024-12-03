package example.corejava.stream;

import java.util.stream.IntStream;

public class FibonacciStreamExample {
    public static void main(String[] args) {
        int n = 10;
        IntStream.range(0, n)
                .map(i -> i == 0 ? 0 : i == 1 ? 1 : fib(i))
                .forEach(System.out::println);
    }

    private static int fib(int n) {
        return n <= 1 ? n : fib(n - 1) + fib(n - 2);
    }
}
