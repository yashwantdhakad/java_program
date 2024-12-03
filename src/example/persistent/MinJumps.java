package example.persistent;

class MinJumps {
    public static int minJumps(int[] arr) {
        if (arr.length <= 1) {
            return 0; // No need to jump if array has 1 element
        }

        if (arr[0] == 0) {
            return -1; // If the first element is 0, we can't move anywhere
        }

        int maxReach = arr[0]; // Maximum reachable index
        int steps = arr[0];    // Steps available in the current jump
        int jumps = 1;         // Minimum jumps needed

        for (int i = 1; i < arr.length; i++) {
            if (i == arr.length - 1) {
                return jumps; // If reached the end, return jumps
            }

            maxReach = Math.max(maxReach, i + arr[i]); // Update the maxReach
            steps--; // Use one step

            if (steps == 0) {
                jumps++; // Need another jump
                if (i >= maxReach) {
                    return -1; // Can't move forward
                }
                steps = maxReach - i; // Reset steps to the number of steps we can take from current position
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = {2, 3, 1, 1, 4};
        System.out.println("Minimum number of jumps to reach end is " + minJumps(arr)); // Output: 2
    }
}
