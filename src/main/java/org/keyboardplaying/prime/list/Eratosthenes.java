package org.keyboardplaying.prime.list;

import java.util.Arrays;

/**
 * An implementation of the sieve of Eratosthene.
 *
 * @author Cyrille Chopelet (http://keyboardplaying.org)
 */
// TODO Javadoc
public class Eratosthenes {

    private static final int FIRST_PRIME = 2;

    public boolean[] makeSieve(int max) {
        boolean[] sieve = new boolean[max + 1];
        Arrays.fill(sieve, FIRST_PRIME, sieve.length, true);

        double rootMax = Math.sqrt(max);

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
