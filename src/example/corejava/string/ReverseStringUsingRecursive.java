package example.corejava.string;

public class ReverseStringUsingRecursive {
    public static String reverseString(String str) {
        if (str == null || str.length() <= 1) {
            return str;
        }
        return str.charAt(str.length() - 1) + reverseString(str.substring(0, str.length() -1));
    }

    public static void main(String args[]) {
        String s="Hello";
        System.out.println("==original string: " + s);
        System.out.println("====reverse string: " + reverseString(s));
        String reverseString = "";
        for (int i=s.length()-1; i>=0 ;i--) {
            reverseString += s.charAt(i);
        }
        System.out.println("====reverse str==="+ reverseString);
        String str = "";
        for (int i=0; i < s.length(); i++) {
            str = str + s.substring(s.length()-i-1, s.length()-i);
        }
        System.out.println("===str==="+str);
    }
}
