package example.persistent;

import java.util.LinkedHashMap;
import java.util.Map;

public class NthNonRepeatingCharacter {
    public static Character findNthNonRepeatingChar(String str, int n) {
        Map<Character, Integer> freqMap = new LinkedHashMap<>();
        for (Character ch : str.toLowerCase().toCharArray()) {
            if (ch != ' ') {
                freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
            }
        }
        System.out.print("Map is: " + freqMap);
        int count = 0;
        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() == 1) {
                count++;
                if (count == n) {
                    return entry.getKey();
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        String s = "Geeks for Geeks";
        int n = 2;
        Character nthNonRepeatingChar = findNthNonRepeatingChar(s, n);
        System.out.print("N th char: " + nthNonRepeatingChar);
    }
}
