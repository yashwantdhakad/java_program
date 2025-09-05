package example.persistent;

public class A6NumberToWords {

    // Arrays for words corresponding to digits
    private static final String[] belowTwenty = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static final String[] tens = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private static final String[] thousands = {"", "Thousand", "Million", "Billion", "Trillion"}; // Extended for larger numbers

    // Main function to convert number into words
    public static String numberToWords(long num) { // Changed to long for larger numbers
        if (num < 0) throw new IllegalArgumentException("Negative numbers not supported");
        if (num == 0) return "Zero";

        int i = 0;
        StringBuilder words = new StringBuilder();

        while (num > 0) {
            if (num % 1000 != 0) {
                String groupWords = helper((int) (num % 1000));
                words.insert(0, groupWords + (groupWords.isEmpty() ? "" : thousands[i] + " "));
            }
            num /= 1000;
            i++;
            if (i >= thousands.length) throw new IllegalArgumentException("Number too large");
        }

        return words.toString().trim();
    }

    // Helper function to convert numbers below 1000 into words
    private static String helper(int num) {
        if (num == 0) return "";
        if (num < 20) return belowTwenty[num];
        else if (num < 100) {
            String tensPart = tens[num / 10];
            String remainder = helper(num % 10);
            return tensPart + (remainder.isEmpty() ? "" : " " + remainder);
        } else {
            String hundredsPart = belowTwenty[num / 100] + " Hundred";
            String remainder = helper(num % 100);
            return hundredsPart + (remainder.isEmpty() ? "" : " " + remainder);
        }
    }

    public static void main(String[] args) {
        // Test the conversion
        System.out.println(numberToWords(123));        // "One Hundred Twenty Three"
        System.out.println(numberToWords(1001));       // "One Thousand One"
        System.out.println(numberToWords(1000000));    // "One Million"
        System.out.println(numberToWords(123456789));  // "One Hundred Twenty Three Million Four Hundred Fifty Six Thousand Seven Hundred Eighty Nine"
        System.out.println(numberToWords(0));          // "Zero"
    }
}