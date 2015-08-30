package org.keyboardplaying.roman;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * Test for the {@link RomanConverter}.
 *
 * @author Cyrille Chopelet (http://keyboardplaying.org)
 */
public class RomanConverterTest {

    private RomanConverter rc = new RomanConverter();

    /** Tests {@link RomanConverter#from(String)}. */
    @Test
    public void testFrom() {
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

    /** Tests {@link RomanConverter#to(int)}. */
    @Test
    public void testTo() {
        // Min/max
        assertEquals("", rc.to(0));
        assertEquals("MMMDCCLXXVII", rc.to(3777));

        // More complicated
        assertEquals("XLIX", rc.to(49));
        assertEquals("XCIX", rc.to(99));
        assertEquals("DI", rc.to(501));
        assertEquals("MCMLXXXV", rc.to(1985));
    }

    /** Tests {@link RomanConverter#to(int)} for a negative value. */
    @Test(expected = IllegalArgumentException.class)
    public void testToWithNegative() {
        rc.to(-1);
    }

    /** Tests {@link RomanConverter#to(int)} for a value too large for the converter. */
    @Test(expected = IllegalArgumentException.class)
    public void testToWithTooLarge() {
        rc.to(3778);
    }
}
