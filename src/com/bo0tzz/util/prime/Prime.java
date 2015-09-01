package com.bo0tzz.util.prime;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by bo0tzz
 */
public class Prime {
    private static HashMap<Integer,Boolean> N;

    public static List<Integer> getPrimes(int cap) {
        N = new HashMap<Integer,Boolean>(cap);
        List<Integer> output = new ArrayList<>();
        for (int i = 1; i <= cap; i++) {
            N.put(i, false);
        }

        int p = 2;
        wh: while (true) {
            int temp = p;
            for (int i = 2; temp < cap; i++) {
                temp = p * i;
                N.replace(temp, true);
            }

            for (int i = p+1; i <= cap; i++) {
                if (!N.get(i)) {
                    p = i;
                    break;
                } else if (i == cap) {
                    break wh;
                }
            }
        }

        int size = N.size();
        for (int i = 1; i <= size; i++) {
            if (N.get(i)) {
                N.remove(i);
            }
        }

        N.forEach((x, y) -> output.add(x));
        return output;
    }
}
