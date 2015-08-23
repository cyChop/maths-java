package org.keyboardplaying.roman;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Test for the {@link RomanConverter}.
 *
 * @author Cyrille Chopelet (http://keyboardplaying.org)
 */
public class RomanConverterTest {

    @Test
    public void fromTest() {
        RomanConverter rc = new RomanConverter();

        // Empty
        assertEquals(0, rc.from(null));
        assertEquals(0, rc.from("  "));

        // Some basics
        assertEquals(1, rc.from("I"));
        assertEquals(3, rc.from("iii"));
        assertEquals(5, rc.from("V"));

        // Some advanced and strange variants
        // (https://en.wikipedia.org/wiki/Roman_numerals#Roman_numeric_system)
        assertEquals(1904, rc.from("MCMIV"));
        assertEquals(1954, rc.from("MCMLIV"));
        assertEquals(1990, rc.from("MCMXC"));
        assertEquals(2014, rc.from("MMXIV"));
        assertEquals(18, rc.from("XIIX"));
        assertEquals(18, rc.from("IIXX"));
        assertEquals(18, rc.from("XVIII"));
        assertEquals(1910, rc.from("MDCCCCX"));
        assertEquals(1903, rc.from("MDCDIII"));
    }
}
