package example.corejava.other;

import java.util.Arrays;

public class AnagramExample {
    public static void main(String[] args) {
        String str1 = "test message2";
        String str2 = "test message1";

        if (str1.length() == str2.length()) {
            char[] charStr1 = str1.toCharArray();
            char[] charStr2 = str2.toCharArray();

            Arrays.sort(charStr1);
            Arrays.sort(charStr2);

            boolean isAnagram = Arrays.equals(charStr1, charStr2);
            if (isAnagram) {
                System.out.println("Strings are anagram");
            } else {
                System.out.println("Strings are not anagram");
            }
        }
    }
}
