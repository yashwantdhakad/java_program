package example.corejava.perci2;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static int[] twoSumBF(int[] nums, int target) {
        for (int i=0; i< nums.length; i++) {
            for (int j=i+1; j< nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i,j};
                }
            }
        }
        throw new IllegalArgumentException("Invalid sum.");
    }
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (map.containsKey(temp)) {
                return new int[] {map.get(temp), i};
            }
            map.put(nums[i], i);
        }

        throw new IllegalArgumentException("No two sum solution.");
    }

    public static void main(String[] args) {
        int[] nums = {2, 11, 7, 15};
        int target = 9;

        int[] result = twoSum(nums, target);
        int[] result1 = twoSumBF(nums, target);
        System.out.println("Indices: [" + result[0] + ", " + result[1] + "]");
        System.out.println("Indices with BF: [" + result1[0] + ", " + result1[1] + "]");
    }
}
