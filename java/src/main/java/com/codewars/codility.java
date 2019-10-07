package com.codewars;

import java.util.Arrays;

public class codility {

    public static int solution(int[] A) {
        // write your code in Java SE 8
        Arrays.sort(A);
        int maxPlus = 1;
        for (int i=0; i< A.length-1; i++) {
            if ((A[i] > 0) && ((A[i+1] - A[i]) >=2)) {
                maxPlus = A[i] + 1;
                break;
            }
        }
        return (maxPlus == 1 ? (A[0] >= 2 ? A[0] - 1 : (A[A.length - 1] + 1 > 0 ? A[A.length - 1] + 1 : 1)) : maxPlus );
     }
}
