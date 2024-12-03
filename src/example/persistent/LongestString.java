package example.persistent;

import java.util.HashMap;
import java.util.Map;

public class LongestString {
    public static String findLongestString(String str, int k) {
        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0, left=0, right=0, longestStart=0;
        while (right < str.length()) {
            char charAtRight = str.charAt(right);
            map.put(charAtRight, map.getOrDefault(charAtRight, 0) + 1);

            while (map.size() > k) {
                char charAtLeft = str.charAt(left);
                map.put(charAtLeft, map.get(charAtLeft) -1);
                if (map.get(charAtLeft) == 0) {
                    map.remove(charAtLeft);
                }
                left++;
            }
            if (right-left +1 > maxLength) {
                maxLength = right-left+1;
                longestStart = left;
            }
            right++;
        }
        return str.substring(longestStart, longestStart + maxLength);
    }

    public static void main(String[] args) {
        String s = "araaci";
        int k =2;
        System.out.println("Longest String with " + k + " char is : " + findLongestString(s, k));
    }
}
