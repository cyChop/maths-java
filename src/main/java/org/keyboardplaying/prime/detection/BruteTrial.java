package org.keyboardplaying.prime.detection;

import java.util.ArrayList;
import java.util.List;

import org.keyboardplaying.prime.Constants;

/**
 * A first attempt at writing a prime detection algorithm.
 *
 * @author Cyrille Chopelet (http://keyboardplaying.org)
 */
public class BruteTrial {

    /**
     * Decomposes an integer into its prime factors.
     *
     * @param integer
     *            the integer to factorize
     * @return {@code true} if the supplied integer is prime
     */
    public boolean isPrime(int integer) {
        if (integer < Constants.FIRST_PRIME) {
            return false;
        }

        final int max = (int) Math.ceil(Math.sqrt(integer));
        List<Integer> primes = new ArrayList<>();

        if (isDividableByPrime(integer, Constants.FIRST_PRIME, primes)) {
            return false;
        }

        // test all odd numbers
        int current = Constants.NEXT_PRIME;
        while (current <= max) {
            if (isDividableByPrime(integer, current, primes)) {
                return false;
            }
            current += Constants.STEP;
        }

        return true;
    }

    private boolean isDividableByPrime(int value, int current, List<Integer> primes) {
        if (isPrime(current, primes) && value != current && value % current == 0) {
            return true;
        }
        return false;
    }

    private boolean isPrime(int current, List<Integer> primes) {
        boolean primeCurrent = true;
        for (Integer prime : primes) {
            if (current % prime == 0) {
                primeCurrent = false;
            }
        }
        return primeCurrent;
    }
}
