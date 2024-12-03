package example.corejava.other;

public class StringPalindrome {
    public static void main(String[] args) {
        String message = "Madam";
        StringBuilder strBlrd = new StringBuilder(message);
        System.out.println(strBlrd.reverse());
        if (message.equals(strBlrd.reverse().toString())) {
            System.out.println("String is palindrome");
        } else {
            System.out.println("String is not palindrome");
        }
    }
}
