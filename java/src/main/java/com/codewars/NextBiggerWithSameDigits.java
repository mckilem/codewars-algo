package com.codewars;

import java.util.Arrays;

public class NextBiggerWithSameDigits {

    // Utility function to swap two digit
    static void swap(char ar[], int i, int j)
    {
        char temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;
    }

    public static long nextBiggerNumber(long n) {

        //https://www.geeksforgeeks.org/find-next-greater-number-set-digits/
        long result;
        int i;
        int len = String.valueOf(n).length();
        char[] arr = String.valueOf(n).toCharArray();

        // I) Start from the right most digit
        // and find the first digit that is smaller
        // than the digit next to it.
        for (i = len - 1; i > 0; i--) {
            if (arr[i] > arr[i - 1]) {
                break;
            }
        }

        // If no such digit is found, then all
        // digits are in descending order means
        // there cannot be a greater number with
        // same set of digits
        if (i == 0) {
            result = -1;
        } else {
            int x = arr[i - 1], min = i;

            // II) Find the smallest digit on right
            // side of (i-1)'th digit that is greater
            // than number[i-1]
            for (int j = i + 1; j < len; j++) {
                if (arr[j] > x && arr[j] < arr[min]) {
                    min = j;
                }
            }

            // III) Swap the above found smallest
            // digit with number[i-1]
            swap(arr, i - 1, min);

            // IV) Sort the digits after (i-1)
            // in ascending order
            Arrays.sort(arr, i, len);
            result = Long.parseLong(String.valueOf(arr));
        }
        return result;
    }
}
