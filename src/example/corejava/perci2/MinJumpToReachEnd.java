package example.corejava.perci2;

public class MinJumpToReachEnd {
    public static int findMinJump(int[] nums) {
        if (nums == null) return -1;
        if (nums.length <= 1) return 0;

        int maxNumOfSteps = nums[0];
        int steps = nums[0];
        int jumps = 1;

        for (int i = 0; i < nums.length; i++) {
            if (i == nums.length - 1) return jumps;
            maxNumOfSteps = Math.max(maxNumOfSteps, nums[i] + i);
            steps--;
            if (steps == 0) {
                jumps++;
                if (i >= maxNumOfSteps) return -1;
                steps = maxNumOfSteps - i;
            }
        }

        return jumps;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println("jumps: " + findMinJump(nums));
    }
}
