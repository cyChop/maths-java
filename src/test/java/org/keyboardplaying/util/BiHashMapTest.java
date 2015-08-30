package org.keyboardplaying.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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

        map.put("A", 1);
        map.put("B", 2);
        assertTrue(map.containsKey("A"));
        assertSize(2, map);

        map.put("1", 1);
        assertFalse(map.containsKey("A"));
        assertTrue(map.containsValue(2));
        assertSize(2, map);

        map.removeValue(2);
        assertFalse(map.containsValue(2));
        assertSize(1, map);

        map.remove("1");
        assertSize(0, map);
    }

    private void assertSize(int expected, BiHashMap<String, Integer> map) {
        assertEquals(expected == 0, map.isEmpty());
        assertEquals(expected, map.size());
        assertEquals(expected, map.keySet().size());
        assertEquals(expected, map.values().size());
    }
}
