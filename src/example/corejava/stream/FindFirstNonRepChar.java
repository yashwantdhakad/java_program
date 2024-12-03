package example.corejava.stream;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

public class FindFirstNonRepChar {
    public static void main(String[] args) {
        String name = "ashwant";
        Map<Object, Integer> integerMap = name.chars().mapToObj(c -> (char) c).collect(LinkedHashMap<Object, Integer>::new, (map, c) -> map.put(c, map.getOrDefault(c, 0) + 1), LinkedHashMap<Object, Integer>::putAll);
        Object ch = integerMap.entrySet().stream().filter(entry -> entry.getValue() == 1).findFirst().get().getKey();
        System.out.println(ch);

    }
}
