package org.keyboardplaying.prime.list;

import java.util.Arrays;

/**
 * An implementation of the sieve of Eratosthene.
 *
 * @author Cyrille Chopelet (http://keyboardplaying.org)
 */
public class Eratosthenes {

    private static final int FIRST_PRIME = 2;

    /**
     * Generates a sieve of Eratosthenes up to supplied value.
     * <p/>
     * The sieve will be returned as an array. The index will be the number, and for each index, the value will be
     * {@code true} for a prime number, {@code false} otherwise.
     *
     * @param max
     *            the maximum value for the sieve
     * @return the sieve
     */
    public boolean[] makeSieve(int max) {
        boolean[] sieve = new boolean[max + 1];
        Arrays.fill(sieve, FIRST_PRIME, sieve.length, true);

        double rootMax = Math.ceil(Math.sqrt(max));

        for (int i = FIRST_PRIME; i <= rootMax; i++) {
            if (sieve[i]) {
                for (int j = i * i; j <= max; j += i) {
                    sieve[j] = false;
                }
            }
        }

        return sieve;
    }
}
