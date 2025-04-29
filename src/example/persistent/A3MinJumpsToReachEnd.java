package example.persistent;

class A3MinJumpsToReachEnd {
    public static int minJumps(int[] arr) {
        // Edge cases
        if (arr == null) return -1;
        if (arr.length <= 1) return 0;

        // If the first element is 0, we can't move
        if (arr[0] == 0) return -1;

        int maxReachableIndex = arr[0]; // Farthest index we can reach
        int remainingSteps = arr[0];    // Steps available in the current jump
        int jumps = 1;                  // Minimum jumps needed

        for (int i = 1; i < arr.length; i++) {
            if (i == arr.length - 1) return jumps;

            // Update the farthest reachable index
            maxReachableIndex = Math.max(maxReachableIndex, i + arr[i]);
            remainingSteps--; // Use one step

            if (remainingSteps == 0) {
                jumps++; // Need another jump
                if (i >= maxReachableIndex) return -1; // Cannot move forward
                remainingSteps = maxReachableIndex - i; // Reset steps
            }
        }
        // Unreachable code due to the loop structure
        return jumps;
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 3, 1, 1, 4};
        System.out.println("Minimum number of jumps to reach end is " + minJumps(arr1));

        // Additional test cases
        int[] arr2 = {1, 1, 1, 1, 1};
        System.out.println("Minimum jumps: " + minJumps(arr2));

        int[] arr3 = {1, 0, 2};
        System.out.println("Minimum jumps (unreachable): " + minJumps(arr3));
    }
}