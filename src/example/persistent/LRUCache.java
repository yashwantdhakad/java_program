package example.persistent;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K, V> extends LinkedHashMap<K, V> {
    int capacity;
    public LRUCache(int capacity) {
        super(capacity, 0.75F, true);
        this.capacity = capacity;
    }
    @Override
    public boolean removeEldestEntry(Map.Entry entry) {
        return size() > capacity;
    }

    public V getValue(K key) {
        return getOrDefault(key, null);
    }
    public void putValue(K key, V value) {
        put(key, value);
    }

    public static void main(String[] args) {
        LRUCache<Integer, String> cache = new LRUCache<>(2);
        cache.put(1, "One");
        cache.put(2, "Two");
        System.out.println(cache.getValue(1));  // Output: One
        cache.put(3, "Three");
        System.out.println(cache.getValue(2));  // Output: null
        System.out.println("Map is: " + cache);
    }
}
