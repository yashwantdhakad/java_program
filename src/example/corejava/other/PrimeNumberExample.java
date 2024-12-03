package example.corejava.other;

public class PrimeNumberExample {
    public static void main(String[] args) {
        boolean isPrime = true;
        int n = 7;
        int m = n/2;
        for(int i =2; i <= m; i++) {
            if (n % i == 0) {
                isPrime = false;
                break;
            }
        }
        if (isPrime) {
            System.out.println("Number is prime");
        } else {
            System.out.println("Number is not prime");
        }
    }
}
