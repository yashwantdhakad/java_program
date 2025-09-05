package example.corejava.other;

import java.util.*;

public class OddOneOutFinder {
    public static String findOddString(String[] series) {
        Map<String, List<String>> patternMap = new HashMap<>();

        for (String s : series) {
            String pattern = getPattern(s);
            System.out.println("===pattern=="+pattern);
            patternMap.putIfAbsent(pattern, new ArrayList<>());
            patternMap.get(pattern).add(s);
            System.out.println("===patternMap=="+patternMap);
        }

        // Return the one with only one occurrence
        for (List<String> list : patternMap.values()) {
            if (list.size() == 1) return list.get(0);
        }

        return "";
    }

    private static String getPattern(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < s.length(); i++) {
            sb.append((s.charAt(i) - s.charAt(i - 1)) + ",");
            System.out.println("===sb=="+sb);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] input = {"ABC", "BCD", "EFG", "DCB"};
        System.out.println(findOddString(input)); // Output: DCB
    }
}

