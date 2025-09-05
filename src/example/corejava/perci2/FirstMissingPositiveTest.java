package example.corejava.perci2;

import java.util.Arrays;

public class FirstMissingPositiveTest {
    public static int firstMissingPositive(int[] nums) {

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] < n && nums[nums[i] - 1] != nums[i]) {
                int temp = nums[nums[i]-1];
                nums[nums[i]-1] = nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i+1;
            }
        }

        return n+1;
    }

    public static void main(String[] args) {
        test(new int[]{1, 2, 0}, 3);             // All in [1,2], missing 3
        test(new int[]{3, 4, -1, 1}, 2);         // Missing 2
        test(new int[]{7, 8, 9, 11, 12}, 1);     // 1 is the first missing
        test(new int[]{1}, 2);                   // Only 1 is present
        test(new int[]{2}, 1);                   // 1 is missing
        test(new int[]{}, 1);                    // Empty array
        test(new int[]{1, 2, 3, 4, 5}, 6);       // All positives in sequence
        test(new int[]{-1, -2, -3}, 1);          // Only negatives
        test(new int[]{0}, 1);                   // Only zero
        test(new int[]{1, 1000}, 2);             // Large gap after 1
        test(new int[]{2, 2, 2, 2}, 1);          // Duplicates only, missing 1
        test(new int[]{1, 2, 6, 3, 5, 4, 8}, 7); // Missing 7
        test(new int[]{Integer.MAX_VALUE}, 1);  // Very large positive only
        test(new int[]{1, 2, 0, -1, -2}, 3);     // Mix with negative and 0
        test(new int[]{4, 3, 2, 1}, 5);          // Reverse sorted
        System.out.println("All tests executed.");
    }

    private static void test(int[] nums, int expected) {
        int result = firstMissingPositive(nums); // Replace with actual method
        if (result == expected) {
            System.out.println("Passed for input: " + Arrays.toString(nums));
        } else {
            System.out.println("Failed for input: " + Arrays.toString(nums)
                    + " | Expected: " + expected + ", Got: " + result);
        }
    }

}