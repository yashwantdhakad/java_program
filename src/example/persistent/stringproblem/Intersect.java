package example.persistent.stringproblem;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Intersect {
    public static Set<String> findIntersect(Set<String> s1, Set<String> s2) {
        Set<String> intersect = new HashSet<>();
        s2.forEach(word -> {
            if (s1.contains(word)) {
                intersect.add(word);
            }
        });
        return intersect;
    }
    public static void main(String[] args) {
        Set<String> set1 = new HashSet<>(Arrays.asList("a", "b", "c"));
        Set<String> set2 = new HashSet<>(Arrays.asList("c", "d", "e"));
        System.out.println("Intersect items are: " + findIntersect(set1, set2));
    }
}
