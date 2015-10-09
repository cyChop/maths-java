package org.keyboardplaying.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

/**
 * Test class for the {@link BiHashMap}.
 *
 * @author Cyrille Chopelet (http://keyboardplaying.org)
 */
public class BiHashMapTest {

    /** Tests {@link BiHashMap#put(Object, Object)} and {@link BiHashMap#remove(Object)} (among other methods). */
    @Test
    public void testPutAndRemove() {
        BiHashMap<String, Integer> map = new BiHashMap<>();
        assertSize(0, map);

        Map<String, Integer> all = new HashMap<>();
        all.put("A", 1);
        all.put("B", 2);
        map.putAll(all);

        assertTrue(map.containsKey("A"));
        assertEquals(Integer.valueOf(1), map.get("A"));
        assertEquals("B", map.getKey(2));
        assertNull(map.get("C"));
        assertNull(map.getKey(3));
        assertSize(2, map);

        map.put("1", 1);
        assertFalse(map.containsKey("A"));
        assertTrue(map.containsValue(2));
        assertSize(2, map);

        map.put("1", 0);
        assertTrue(map.containsKey("1"));
        assertFalse(map.containsValue(1));
        assertTrue(map.containsValue(0));
        assertSize(2, map);

        map.removeValue(2);
        assertFalse(map.containsValue(2));
        assertSize(1, map);

        map.remove("1");
        assertSize(0, map);
    }

    /** Tests {@link BiHashMap#clear()}. */
    @Test
    public void testClear() {
        BiHashMap<String, Integer> map = new BiHashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        assertSize(2, map);

        map.clear();
        assertSize(0, map);
    }

    private void assertSize(int expected, BiHashMap<String, Integer> map) {
        assertEquals(expected == 0, map.isEmpty());
        assertEquals(expected, map.size());
        assertEquals(expected, map.entrySet().size());
        assertEquals(expected, map.keySet().size());
        assertEquals(expected, map.values().size());
    }
}
