package example.persistent;

public class StairProblem {
    public static int findWays(int n) {
        if (n <= 0) {
            return 1;
        } else if (n == 1) {
            return 1;
        }
        int[] cs = new int[n + 1];
        cs[0] = 1;
        cs[1] = 1;
        cs[2] = 2;
        for (int i = 3; i <= n; i++) {
            cs[i] = cs[i - 1] + cs[i - 2] + cs[i - 3];
        }
        return cs[n];
    }

    public static void main(String[] args) {
        int n = 6;
        System.out.println("No of ways: " + findWays(n));
    }
}
