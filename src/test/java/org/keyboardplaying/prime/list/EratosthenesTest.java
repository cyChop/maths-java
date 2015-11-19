package org.keyboardplaying.prime.list;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.keyboardplaying.prime.PrimeNumbers;

/**
 * Unit test for {@link Eratosthenes}.
 *
 * @author Cyrille Chopelet (http://keyboardplaying.org)
 */
public class EratosthenesTest {

    /** Tests {@link Eratosthenes#makeSieve(int)}. */
    @Test
    public void testMakeSieve() {
        testSieve(2);
        testSieve(3);
        testSieve(7);
        testSieve(1000);
    }

    private void testSieve(int max) {
        boolean[] sieve = new Eratosthenes().makeSieve(max);
        for (int i = 0; i < sieve.length; i++) {
            boolean prime = PrimeNumbers.PRIMES.contains(Integer.valueOf(i));
            boolean sieveTrue = sieve[i];
            assertEquals("The sieve should be " + prime + " but is " + sieveTrue, prime, sieveTrue);
        }
    }
}
