package org.keyboardplaying.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * An implementation of {@link BiMap} based on two {@link HashMap}.
 *
 * @author Cyrille Chopelet (http://keyboardplaying.org)
 *
 * @param <K>
 *            the type of the keys
 * @param <V>
 *            the type of the values
 */
public class BiHashMap<K, V> implements BiMap<K, V> {

    private Map<K, V> normal;
    private Map<V, K> reverse;

    /** Creates a new instance. */
    public BiHashMap() {
        this.normal = new HashMap<>();
        this.reverse = new HashMap<>();
    }

    /*
     * (non-Javadoc)
     *
     * @see java.util.Map#size()
     */
    @Override
    public int size() {
        return normal.size();
    }

    /*
     * (non-Javadoc)
     *
     * @see java.util.Map#isEmpty()
     */
    @Override
    public boolean isEmpty() {
        return normal.isEmpty();
    }

    /*
     * (non-Javadoc)
     *
     * @see java.util.Map#containsKey(java.lang.Object)
     */
    @Override
    public boolean containsKey(Object key) {
        return normal.containsKey(key);
    }

    /*
     * (non-Javadoc)
     *
     * @see java.util.Map#containsValue(java.lang.Object)
     */
    @Override
    public boolean containsValue(Object value) {
        return reverse.containsKey(value);
    }

    /*
     * (non-Javadoc)
     *
     * @see java.util.Map#get(java.lang.Object)
     */
    @Override
    public V get(Object key) {
        return normal.get(key);
    }

    /*
     * (non-Javadoc)
     *
     * @see java.util.Map#remove(java.lang.Object)
     */
    @Override
    public V remove(Object key) {
        V value = normal.remove(key);
        reverse.remove(value);
        return value;
    }

    /*
     * (non-Javadoc)
     *
     * @see java.util.Map#putAll(java.util.Map)
     */
    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        for (Entry<? extends K, ? extends V> entry : m.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    /*
     * (non-Javadoc)
     *
     * @see java.util.Map#clear()
     */
    @Override
    public void clear() {
        normal.clear();
        reverse.clear();
    }

    /*
     * (non-Javadoc)
     *
     * @see java.util.Map#keySet()
     */
    @Override
    public Set<K> keySet() {
        return normal.keySet();
    }

    /*
     * (non-Javadoc)
     *
     * @see java.util.Map#entrySet()
     */
    @Override
    public Set<java.util.Map.Entry<K, V>> entrySet() {
        return normal.entrySet();
    }

    /*
     * (non-Javadoc)
     *
     * @see org.keyboardplaying.util.BiMap#put(java.lang.Object, java.lang.Object)
     */
    @Override
    public V put(K key, V value) {
        if (normal.containsKey(key)) {
            reverse.remove(normal.get(key));
        }
        if (reverse.containsKey(value)) {
            normal.remove(reverse.get(value));
        }
        V obj = normal.put(key, value);
        reverse.put(value, key);
        return obj;
    }

    /*
     * (non-Javadoc)
     *
     * @see org.keyboardplaying.util.BiMap#getKey(java.lang.Object)
     */
    @Override
    public K getKey(Object value) {
        return reverse.get(value);
    }

    /*
     * (non-Javadoc)
     *
     * @see org.keyboardplaying.util.BiMap#removeValue(java.lang.Object)
     */
    @Override
    public K removeValue(Object value) {
        K key = reverse.remove(value);
        normal.remove(key);
        return key;
    }

    /*
     * (non-Javadoc)
     *
     * @see org.keyboardplaying.util.BiMap#values()
     */
    @Override
    public Set<V> values() {
        return reverse.keySet();
    }
}
