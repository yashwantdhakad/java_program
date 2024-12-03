package example.corejava.other;

public class FibonacciExample {
    public static void main(String[] args) {
        int n = 20;
        int a = 0;
        int b = 1;

        for(int i = 0; i < n; i++) {
            System.out.println(a);
            int c = a + b;
            a = b;
            b = c;
        }
    }
}
