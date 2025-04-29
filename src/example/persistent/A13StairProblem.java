package example.persistent;

public class A13StairProblem {
    public static long findWays(int n) {
        // Validate input
        if (n < 0) {
            throw new IllegalArgumentException("Number of stairs cannot be negative");
        }
        if (n == 0) {
            return 1; // One way: take no steps
        }

        // Handle base cases
        if (n == 1) return 1;
        if (n == 2) return 2;

        // Use variables instead of array for O(1) space
        long prev3 = 1; // Ways to reach step 0
        long prev2 = 1; // Ways to reach step 1
        long prev1 = 2; // Ways to reach step 2
        long current = 0;

        // Compute ways for steps 3 to n
        for (int i = 3; i <= n; i++) {
            current = prev1 + prev2 + prev3;
            prev3 = prev2;
            prev2 = prev1;
            prev1 = current;
        }

        return current;
    }

    public static void main(String[] args) {
        try {
            int n = 6;
            System.out.println("Number of stairs: " + n);
            System.out.println("Number of ways: " + findWays(n));

            // Additional test cases
            System.out.println("\nTest cases:");
            System.out.println("n = 0: " + findWays(0));
            System.out.println("n = 1: " + findWays(1));
            System.out.println("n = 2: " + findWays(2));
            System.out.println("n = 3: " + findWays(3));
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}