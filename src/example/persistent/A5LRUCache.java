package example.persistent;

import java.util.LinkedHashMap;
import java.util.Map;

public class A5LRUCache<K, V> extends LinkedHashMap<K, V> {
    private final int capacity;

    public A5LRUCache(int capacity) {
        super(capacity, 0.75F, true); // Access-order mode
        if (capacity <= 0) throw new IllegalArgumentException("Capacity must be positive");
        this.capacity = capacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > capacity; // Remove least recently used entry if size exceeds capacity
    }

    public V get(Object key) {
        return getOrDefault(key, null); // Get value, return null if not found
    }

    public V put(K key, V value) {
        super.put(key, value); // Insert or update key-value pair
        return value;
    }

    public static void main(String[] args) {
        A5LRUCache<Integer, String> cache = new A5LRUCache<>(2);
        cache.put(1, "One");
        cache.put(2, "Two");
        System.out.println("Get 1: " + cache.get(1));  // Output: One
        cache.put(3, "Three");
        System.out.println("Get 2: " + cache.get(2));  // Output: null

        // Additional test cases
        A5LRUCache<Integer, String> cache2 = new A5LRUCache<>(1);
        cache2.put(1, "One");
        cache2.put(2, "Two");
        System.out.println("Get 1 (capacity 1): " + cache2.get(1));  // Output: null
    }
}