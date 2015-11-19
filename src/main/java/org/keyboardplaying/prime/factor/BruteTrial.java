package org.keyboardplaying.prime.factor;

import java.util.ArrayList;
import java.util.List;

import org.keyboardplaying.prime.Constants;

/**
 * A first attempt at writing a prime factorization algorithm.
 *
 * @author Cyrille Chopelet (http://keyboardplaying.org)
 */
public class BruteTrial {

    /**
     * Decomposes an integer into its prime factors.
     *
     * @param integer
     *            the integer to factorize
     * @return the prime factors for the supplied integer
     */
    public List<Integer> factorize(int integer) {
        List<Integer> factors = new ArrayList<>();

        if (integer < Constants.FIRST_PRIME) {
            factors.add(integer);
        } else {
            final int max = (int) Math.ceil(Math.sqrt(integer));
            List<Integer> primes = new ArrayList<>();

            // test 2
            int value = useFactor(integer, Constants.FIRST_PRIME, primes, factors);

            // test all odd numbers
            int current = Constants.NEXT_PRIME;
            while (value != 1 && current <= max) {
                value = useFactor(value, current, primes, factors);
                current += Constants.STEP;
            }

            if (value != 1) {
                factors.add(value);
            }
        }

        return factors;
    }

    private int useFactor(int value, int factor, List<Integer> primes, List<Integer> factors) {
        boolean primeCurrent = isPrime(factor, primes);
        int result = value;

        if (primeCurrent) {
            while (result % factor == 0) {
                factors.add(factor);
                result /= factor;
            }
        }
        return result;
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
