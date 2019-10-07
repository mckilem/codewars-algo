package com.codewars;

public class Magnets {
    public static double doubles(int maxk, int maxn) {
        return fullFunc(maxk, maxn);
    }

    public static double vFunc(int k, int n) {
        return (1/(k*Math.pow(n+1, 2*k)));
    }

    public static double rowFunc(int k, int n) {
        double sum = 0;
        for (int i=1; i<= n; i++) {
            sum += vFunc(k, i);
        }
        return sum;
    }

    public static double fullFunc(int k, int n) {
        double sum = 0;
        for (int i=1; i<= k; i++) {
            sum += rowFunc(i, n);
        }
        return sum;
    }

}
