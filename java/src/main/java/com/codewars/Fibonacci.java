package com.codewars;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIGlobalBinding;

import java.math.*;
import java.util.HashMap;
import java.util.Map;

public class Fibonacci
{
    //https://www.nayuki.io/res/fast-fibonacci-algorithms/FastFibonacci.java
    /*
     * Fast doubling method. Faster than the matrix method.
     * F(2n) = F(n) * (2*F(n+1) - F(n)).
     * F(2n+1) = F(n+1)^2 + F(n)^2.
     * This implementation is the non-recursive version. See the web page and
     * the other programming language implementations for the recursive version.
     */
    public static BigInteger fib(BigInteger val) {
        BigInteger a = BigInteger.ZERO;
        BigInteger b = BigInteger.ONE;
        int n = val.intValue();
        int m = 0;
        for (int bit = Integer.highestOneBit(n); bit != 0; bit >>>= 1) {
            // Loop invariant: a = F(m), b = F(m+1)
            assert a.equals(slowFibonacci(m));
            assert b.equals(slowFibonacci(m+1));

            // Double it
            BigInteger d = multiply(a, b.shiftLeft(1).subtract(a));
            BigInteger e = multiply(a, a).add(multiply(b, b));
            a = d;
            b = e;
            m *= 2;
            assert a.equals(slowFibonacci(m));
            assert b.equals(slowFibonacci(m+1));

            // Advance by one conditionally
            if ((n & bit) != 0) {
                BigInteger c = a.add(b);
                a = b;
                b = c;
                m++;
                assert a.equals(slowFibonacci(m));
                assert b.equals(slowFibonacci(m+1));
            }
        }
        return a;
    }

    /*
     * Simple slow method, using dynamic programming.
     * F(n+2) = F(n+1) + F(n).
     */
    private static BigInteger slowFibonacci(int n) {
        BigInteger a = BigInteger.ZERO;
        BigInteger b = BigInteger.ONE;
        for (int i = 0; i < n; i++) {
            BigInteger c = a.add(b);
            a = b;
            b = c;
        }
        return a;
    }

    // Requirement: CUTOFF >= 64, or else there will be infinite recursion.
    private static final int CUTOFF = 1536;


    /**
     * Returns {@code x * y}, the product of the specified integers. This gives the same result as {@code x.multiply(y)} but should be faster.
     * @param x a multiplicand
     * @param y a multiplicand
     * @return {@code x} times {@code} y
     * @throws NullPointerException if {@code x} or {@code y} is {@code null}
     */
    public static BigInteger multiply(BigInteger x, BigInteger y) {
        if (x.bitLength() <= CUTOFF || y.bitLength() <= CUTOFF) {  // Base case
            return x.multiply(y);

        } else {
            int n = Math.max(x.bitLength(), y.bitLength());
            int half = (n + 32) / 64 * 32;  // Number of bits to use for the low part
            BigInteger mask = BigInteger.ONE.shiftLeft(half).subtract(BigInteger.ONE);
            BigInteger xlow = x.and(mask);
            BigInteger ylow = y.and(mask);
            BigInteger xhigh = x.shiftRight(half);
            BigInteger yhigh = y.shiftRight(half);

            BigInteger a = multiply(xhigh, yhigh);
            BigInteger b = multiply(xlow.add(xhigh), ylow.add(yhigh));
            BigInteger c = multiply(xlow, ylow);
            BigInteger d = b.subtract(a).subtract(c);
            return a.shiftLeft(half).add(d).shiftLeft(half).add(c);
        }
    }

}
