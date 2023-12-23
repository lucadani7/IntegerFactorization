package com.lucadani;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static Map<Long, Long> factorization(long value) {
        Map<Long, Long> factors = new TreeMap<>();
        while (value > 1) {
            long div2 = 0;
            for (; value % 2 == 0; value /= 2) {
                ++div2;
            }
            if (div2 != 0) {
                factors.put(2L, div2);
            }
            for (long i = 3; i * i <= value; i += 2) {
                if (value % i != 0) {
                    continue;
                }
                long div = 0;
                for (; value % i == 0; value /= i) {
                    ++div;
                }
                if (div != 0) {
                    factors.put(i, div);
                }
            }
            if (value > 1) {
                factors.put(value, 1L);
                value = 1;
            }
        }
        return factors;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int value;
        do {
            System.out.print("Type a value: ");
            value = scanner.nextInt();
            if (value >= 2) {
                break;
            }
            System.out.println("Type a value greater than 1!");
        } while (true);
        Map<Long, Long> integerFactorization = factorization(value);
        System.out.println("The integer factorization of " + value + " is here below:");
        for (var factors : integerFactorization.entrySet()) {
            System.out.println(factors.getKey() + " ^ " + factors.getValue());
        }
    }
}