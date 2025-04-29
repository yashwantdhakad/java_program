package example.corejava.string;

// Remove the e char from string
public class RemoveCharFromString {
    public static void main(String[] args) {
        String name="geeksofgeek";
        String newString = "";
        for(int i=0; i<name.length(); i++) {
            if (name.charAt(i) != 'e') {
                newString += name.charAt(i);
            }
        }
        System.out.println("=====newString==="+newString);
    }
}
