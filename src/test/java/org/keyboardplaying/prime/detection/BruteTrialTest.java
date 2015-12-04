package org.keyboardplaying.prime.detection;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.keyboardplaying.prime.PrimeNumbers;

/**
 * Unit test for {@link BruteTrial}.
 *
 * @author Cyrille Chopelet (http://keyboardplaying.org)
 */
public class BruteTrialTest {

    /** Tests {@link BruteTrial#isPrime(int)} */
    @Test
    public void testFactorize() {
        BruteTrial detector = new BruteTrial();
        for (int i = 0; i <= 1000; i++) {
            assertEquals("Detector did not return the expected result for " + i, PrimeNumbers.PRIMES.contains(i),
                    detector.isPrime(i));
        }
    }
}
