package org.keyboardplaying.prime.list;

import java.util.Arrays;

import org.keyboardplaying.prime.Constants;

/**
 * An implementation of the sieve of Eratosthene.
 *
 * @author Cyrille Chopelet (http://keyboardplaying.org)
 */
public class Eratosthenes {

    /**
     * Generates a sieve of Eratosthenes up to supplied value.
     * <p/>
     * The sieve will be returned as an array. The index will be the number, and for each index, the
     * value will be {@code true} for a prime number, {@code false} otherwise.
     *
     * @param max
     *            the maximum value for the sieve
     * @return the sieve
     */
    public boolean[] makeSieve(int max) {
        boolean[] sieve = new boolean[max + 1];
        Arrays.fill(sieve, Constants.FIRST_PRIME, sieve.length, true);

        double rootMax = Math.ceil(Math.sqrt(max));

        useInteger(Constants.FIRST_PRIME, max, sieve);
        for (int i = Constants.NEXT_PRIME; i <= rootMax; i += Constants.STEP) {
            useInteger(i, max, sieve);
        }

        return sieve;
    }

    private void useInteger(int i, int max, boolean[] sieve) {
        if (sieve[i]) {
            for (int j = i * i; j <= max; j += i) {
                sieve[j] = false;
            }
        }
    }
}
