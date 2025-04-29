package example.corejava.stream;

public class StringPalindrome {
    public static void main(String[] args) {
        String str = "madam";
        String reverseStr = new StringBuilder(str).reverse().toString();
        if (reverseStr.equals(str)) {
            System.out.println("String is palindrome");
        } else {
            System.out.println("String is not palindrome");
        }
    }
}
