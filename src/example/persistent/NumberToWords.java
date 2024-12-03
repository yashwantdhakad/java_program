package example.persistent;

public class NumberToWords {

    // Arrays for words corresponding to digits
    private static final String[] belowTwenty = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static final String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private static final String[] thousands = {"", "Thousand", "Million", "Billion"};

    // Main function to convert number into words
    public static String numberToWords(int num) {
        if (num == 0) return "Zero";

        int i = 0;
        String words = "";

        while (num > 0) {
            if (num % 1000 != 0) {
                words = helper(num % 1000) + thousands[i] + " " + words;
            }
            num /= 1000;
            i++;
        }

        return words.trim();
    }

    // Helper function to convert numbers below 1000 into words
    private static String helper(int num) {
        if (num == 0) return "";
        if (num < 20) return belowTwenty[num];
        else if (num < 100) return tens[num / 10] + " " + helper(num % 10);
        else return belowTwenty[num / 100] + " Hundred " + helper(num % 100);
    }

    public static void main(String[] args) {
        // Test the conversion
        System.out.println(numberToWords(123));        // Output: "One Hundred Twenty Three"
        System.out.println(numberToWords(1001));       // Output: "One Thousand One"
        System.out.println(numberToWords(1000000));    // Output: "One Million"
        System.out.println(numberToWords(123456789));  // Output: "One Hundred Twenty Three Million Four Hundred Fifty Six Thousand Seven Hundred Eighty Nine"
    }
}

