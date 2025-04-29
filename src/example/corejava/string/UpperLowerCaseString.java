package example.corejava.string;

public class UpperLowerCaseString {
    public static void main(String[] args) {


        // input name = "hello";
        // output HeLlO;
        String name = "hello";
        String newString = "";
        for (int i = 0; i < name.length(); i++) {
            if (i % 2 == 0) {
                newString +=  String.valueOf(name.charAt(i)).toUpperCase();
            } else {
                newString +=  String.valueOf(name.charAt(i)).toLowerCase();
            }
        }
        System.out.println("====newString==="+newString);
    }
}
