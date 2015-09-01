package com.bo0tzz.util.prime;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by bo0tzz
 */
public class Prime {
    private static HashMap<Long,Boolean> N;

    public static List<Long> getPrimes(int cap) {
        return getPrimes((long)cap);
    }

    public static List<Long> getPrimes(long cap) {
        N = new HashMap<Long,Boolean>();
        List<Long> output = new ArrayList<>();
        for (long i = 1; i <= cap; i++) {
            N.put(i, false);
        }

        long p = 2;
        wh: while (true) {
            long temp = p;
            for (long i = 2; temp < cap; i++) {
                temp = p * i;
                N.replace(temp, true);
            }

            for (long i = p+1; i <= cap; i++) {
                if (!N.get(i)) {
                    p = i;
                    break;
                } else if (i == cap) {
                    break wh;
                }
            }
        }

        long size = N.size();
        for (long i = 1; i <= size; i++) {
            if (N.get(i)) {
                N.remove(i);
            }
        }

        N.forEach((x, y) -> output.add(x));
        return output;
    }

    public static List<Long> factorize(long base) {
        List<Long> factors = new ArrayList<>();
        List<Long> primes = getPrimes(Math.round(Math.sqrt(base)));
        primes.remove(0);

        while (base > 1) {
            for (Long i : primes) {
                if (base % i == 0) {
                    base /= i;
                    factors.add(i);
                }
            }
        }

        return factors;
    }
}
