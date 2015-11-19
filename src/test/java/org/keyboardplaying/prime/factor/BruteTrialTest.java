package org.keyboardplaying.prime.factor;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

/**
 * Unit test for {@link BruteTrial}.
 *
 * @author Cyrille Chopelet (http://keyboardplaying.org)
 */
public class BruteTrialTest {

    /** Tests {@link BruteTrial#factorize(int)} */
    @Test
    public void testFactorize() {
        BruteTrial factor = new BruteTrial();
        assertEquals(Arrays.asList(0), factor.factorize(0));
        assertEquals(Arrays.asList(1), factor.factorize(1));
        assertEquals(Arrays.asList(2), factor.factorize(2));
        assertEquals(Arrays.asList(2, 2), factor.factorize(4));
        assertEquals(Arrays.asList(2, 3, 5, 11), factor.factorize(330));
        assertEquals(Arrays.asList(997), factor.factorize(997));
    }
}
