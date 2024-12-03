package example.persistent;

import java.util.HashMap;
import java.util.Map;

public class FruitProblem {
    public static int findMaxFruits(String[] fruits) {
        int maxFruits=0, left=0, right=0, longestStart=0;
        Map<String, Integer> fuitMap = new HashMap<>();
        while (right < fruits.length) {
            String charAtRight = fruits[right];
            fuitMap.put(charAtRight, fuitMap.getOrDefault(charAtRight, 0) +1);

            if (fuitMap.size() > 2) {
                String charAtLeft = fruits[left];
                fuitMap.put(charAtLeft, fuitMap.getOrDefault(charAtLeft, 0) -1);
                if (fuitMap.get(charAtLeft) == 0) {
                    fuitMap.remove(charAtLeft);
                }
                left++;
            }
            if (right-left+1 > maxFruits) {
                longestStart = left;
            }
            maxFruits = Math.max(maxFruits, right-left + 1);
            right++;
        }
        for(int i =longestStart; i < maxFruits; i++) {
            System.out.println("Max fruites are:" + fruits[i]);
        }
        return maxFruits;
    }

    public static void main(String[] args) {
        String[] fruits = {"apple", "apple", "orange", "apple", "orange", "banana"};
        System.out.println("Maximum fruits: " + findMaxFruits(fruits));
    }
}
