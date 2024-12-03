package example.corejava.stream;

public class RemoveAllOccurrences {
    public static void main(String[] args) {
        String str = "geeks for geeks";
        char ch = 'e';
        // remove all the ch from str using stream
        String newStr = str.chars().filter(c -> c != ch).collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
        System.out.println("New string: " + newStr);

    }
}
