package example.corejava.other;

public class ReverseNumberExample {
    public static void main(String[] args) {
        int n=123456, sum = 0, temp = 0;
        while (n > 0) {
            temp = n % 10;
            sum = (sum * 10) + temp;
            n = n / 10;
        }
        System.out.println("Reverse number is: " + sum);
    }
}
