package example.corejava.stream;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RemoveAllOccurrences {
    public static void main(String[] args) {
        String str = "geeks for geeks";
        char ch = 'e';
        // remove all the ch from str using stream
        String newStr = str.chars().filter(c -> c != ch).collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
        System.out.println("New string: " + newStr);
        String changedStr = str.chars().map(c -> c == 'e' ? 'x': c).mapToObj(c-> String.valueOf((char) c)).collect(Collectors.joining());
        String collect = str.chars().filter(c -> c != 'e').mapToObj(c -> String.valueOf((char) c)).collect(Collectors.joining());
        System.out.println("New string with replace: " + changedStr);
        System.out.println("New string with filter: " + collect);

        String s1 = str.chars()
                .filter(c -> c != ch)
                .mapToObj(c-> String.valueOf((char) c))
                .collect(Collectors.joining());

        String newStr1 = str.chars()
                .filter(c -> c != ch)
                .mapToObj(c -> String.valueOf((char) c))
                .collect(Collectors.joining());
    }
}
