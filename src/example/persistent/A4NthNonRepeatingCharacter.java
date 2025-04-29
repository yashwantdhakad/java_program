package example.persistent;

import java.util.LinkedHashMap;
import java.util.Map;

public class A4NthNonRepeatingCharacter {
    public static Character findNthNonRepeatingChar(String str, int n) {
        // Edge cases
        if (str == null || n <= 0) return null;

        // Use LinkedHashMap to maintain insertion order
        Map<Character, Integer> freqMap = new LinkedHashMap<>();

        // Build frequency map (case-insensitive, ignore spaces)
        for (Character currentChar : str.toLowerCase().toCharArray()) {
            if (currentChar != ' ') {
                freqMap.put(currentChar, freqMap.getOrDefault(currentChar, 0) + 1);
            }
        }

        // Find the Nth non-repeating character
        int count = 0;
        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() == 1) {
                count++;
                if (count == n) {
                    return entry.getKey();
                }
            }
        }
        return null; // Nth non-repeating character doesn't exist
    }

    public static void main(String[] args) {
        String s = "Geeks for Geeks";
        int n = 2;
        Character nthNonRepeatingChar = findNthNonRepeatingChar(s, n);
        System.out.println("Nth non-repeating character: " + (nthNonRepeatingChar != null ? nthNonRepeatingChar : "Not found"));

        // Additional test cases
        System.out.println("Test 1: " + findNthNonRepeatingChar("aabb", 1)); // null
        System.out.println("Test 2: " + findNthNonRepeatingChar("abc", 2)); // 'b'
        System.out.println("Test 3: " + findNthNonRepeatingChar("", 1));    // null
    }
}