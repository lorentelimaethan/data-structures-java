import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MyHashMapTest {
    @Test
    void shouldReturnValueForExistingKey() {
        MyHashMap<String, Integer> map = new MyHashMap<>();
        map.put("Apple", 10);

        Integer value = map.get("Apple");

        assertEquals(10, value);
    }

    @Test
    void shouldReturnNullForMissingKey() {
        MyHashMap<String, Integer> map = new MyHashMap<>();

        Integer value = map.get("Kiwi");

        assertEquals(null, value);
    }

    @Test
    void shouldKeepOriginalValueWhenKeyIsRepeated() {
        MyHashMap<String, Integer> map = new MyHashMap<>();
        map.put("Apple", 10);
        map.put("Apple", 12);

        Integer value = map.get("Apple");

        assertEquals(10, value);
    }

    @Test
    void shouldStoreDifferentKeys() {
        MyHashMap<String, Integer> map = new MyHashMap<>();
        map.put("Apple", 10);
        map.put("Banana", 20);

        Integer value = map.get("Banana");

        assertEquals(20, value);
    }
}
