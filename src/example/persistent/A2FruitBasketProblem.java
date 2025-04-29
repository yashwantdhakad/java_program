package example.persistent;

import java.util.HashMap;
import java.util.Map;

// Problem 2: Fruit basket problem
public class A2FruitBasketProblem {
    public static int findMaxFruits(String[] fruits) {
        // Edge cases
        if (fruits == null || fruits.length == 0) return 0;

        int maxFruits = 0, left = 0, right = 0, longestStart = 0;
        Map<String, Integer> fruitMap = new HashMap<>();

        while (right < fruits.length) {
            String fruitAtRight = fruits[right];
            fruitMap.put(fruitAtRight, fruitMap.getOrDefault(fruitAtRight, 0) + 1);

            // Shrink window if more than 2 distinct fruits
            while (fruitMap.size() > 2) {
                String fruitAtLeft = fruits[left];
                int count = fruitMap.get(fruitAtLeft);
                fruitMap.put(fruitAtLeft, count - 1);
                if (count - 1 == 0) {
                    fruitMap.remove(fruitAtLeft);
                }
                left++;
            }

            // Update maxFruits and longestStart
            int currentLength = right - left + 1;
            if (currentLength > maxFruits) {
                maxFruits = currentLength;
                longestStart = left;
            }
            right++;
        }

        // Print the subarray
        System.out.println("Fruits in the longest basket:");
        for (int i = longestStart; i < longestStart + maxFruits; i++) {
            System.out.println("Fruit: " + fruits[i]);
        }

        return maxFruits;
    }

    public static void main(String[] args) {
        String[] fruits = {"apple", "apple", "orange", "apple", "orange", "banana"};
        System.out.println("Maximum fruits: " + findMaxFruits(fruits));

        // Additional test cases
        String[] test1 = {"apple", "apple", "apple"};
        System.out.println("\nTest 1: " + findMaxFruits(test1));

        String[] test2 = {};
        System.out.println("\nTest 2: " + findMaxFruits(test2));

        // Fruits in the longest basket:
        //Fruit: orange
        //Fruit: apple
        //Fruit: orange
        //Maximum fruits: 3
        //
        //Test 1:
        //Fruits in the longest basket:
        //Fruit: apple
        //Fruit: apple
        //Fruit: apple
        //Test 1: 3
        //
        //Test 2: 0
    }
}