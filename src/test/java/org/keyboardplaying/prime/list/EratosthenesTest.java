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
        boolean[] sieve = new Eratosthenes().makeSieve(1000);
        for (int i = 0; i < sieve.length; i++) {
            boolean prime = PrimeNumbers.PRIMES.contains(Integer.valueOf(i));
            boolean sieveTrue = sieve[i];
            assertEquals("The sieve should be " + prime + " but is " + sieveTrue, prime, sieveTrue);
        }
    }
}
