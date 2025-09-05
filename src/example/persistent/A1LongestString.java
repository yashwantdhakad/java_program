package example.persistent;

import java.util.HashMap;
import java.util.Map;

// Problem 1: Longest Substring with K Distinct Characters
public class A1LongestString {
    public static String longestSubstringWithKDistinct(String str, int k) {
        // Edge cases
        if (str == null || str.isEmpty() || k <= 0) return "";

        Map<Character, Integer> map = new HashMap<>();
        int maxLength = 0, left = 0, right = 0, startIndex = 0;

        while (right < str.length()) {
            char charAtRight = str.charAt(right);
            map.put(charAtRight, map.getOrDefault(charAtRight, 0) + 1);

            while (map.size() > k) {
                char charAtLeft = str.charAt(left);
                int count = map.get(charAtLeft);
                map.put(charAtLeft, count - 1);
                if (count - 1 == 0) {
                    map.remove(charAtLeft);
                }
                left++;
            }

            if (right - left + 1 > maxLength) {
                maxLength = right - left + 1;
                startIndex = left;
            }
            right++;
        }
        return str.substring(startIndex, startIndex + maxLength);
    }

    public static void main(String[] args) {
        String s = "araaci";
        int k = 2;
        System.out.println("Longest substring with " + k + " distinct chars: " + longestSubstringWithKDistinct(s, k));

        // Additional test cases
        System.out.println(longestSubstringWithKDistinct("aaaa", 2)); // "aaaa"
        System.out.println(longestSubstringWithKDistinct("abc", 5));  // "abc"
        System.out.println(longestSubstringWithKDistinct("", 2));    // ""
    }
}