package example.corejava.perci2;

public class StairCaseProblem {
    public static int findWays(int totalSteps) {
        if (totalSteps < 0) {
            throw new IllegalArgumentException("Invalid input.");
        }
        if (totalSteps == 0) return 1;
        if (totalSteps == 1) return 1;
        if (totalSteps == 2) return 2;

        int totalWays = 0;

        int zeroSteps = 1; // 0 stair with step:1
        int oneSteps = 1; // 1 stair with step:1
        int twoSteps = 2; // 2 stairs with step:2
        // Formula to get the number of stair ways
        // ways(n) = ways(n-1) + ways(n-2) + ways(n-3)

        for (int i = 3; i <= totalSteps; i++) {
            totalWays = zeroSteps + oneSteps + twoSteps;
            zeroSteps = oneSteps;
            oneSteps = twoSteps;
            twoSteps = totalWays;
        }

        return totalWays;
    }
    public static void main(String[] args) {
        try {
            int stairs = 6;
            System.out.println("Total stairs: " + stairs);
            System.out.println("Number of ways to climb: " + findWays(stairs));

            // Additional test cases
            System.out.println("\nTest cases:");
            for (int test = 0; test <= 6; test++) {
                System.out.println("n = " + test + ": " + findWays(test));
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
