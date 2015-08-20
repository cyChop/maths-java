package org.keyboardplaying.util;

import java.util.Map;
import java.util.Set;

/**
 * A bi-directional map, allowing to retrieve values from keys and keys from values.
 *
 * @author Cyrille Chopelet (http://keyboardplaying.org)
 */
public interface BiMap<K, V> extends Map<K, V> {

    /**
     * Gets the key that is currently mapped to the specified value.
     *
     * @param value
     *            the value to find the key for
     * @return the mapped key, or <code>null</code> if not found
     */
    K getKey(Object value);

    /**
     * Removes the key-value pair that is currently mapped to the specified value.
     *
     * @param value
     *            the value to find the key-value pair for
     * @return the key that was removed, <code>null</code> if nothing removed
     */
    K removeValue(Object value);

    /**
     * Returns a {@link Set} view of the values contained in this map. The set is backed by the map,
     * so changes to the map are reflected in the set, and vice-versa. If the map is modified while
     * an iteration over the set is in progress (except through the iterator's own <tt>remove</tt>
     * operation), the results of the iteration are undefined. The set supports element removal,
     * which removes the corresponding mapping from the map, via the <tt>Iterator.remove</tt>,
     * <tt>Collection.remove</tt>, <tt>removeAll</tt>, <tt>retainAll</tt> and <tt>clear</tt>
     * operations. It does not support the <tt>add</tt> or <tt>addAll</tt> operations.
     *
     * @return a set view of the values contained in this map
     */
    @Override
    Set<V> values();
}
