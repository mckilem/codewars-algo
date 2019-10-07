package com.codewars;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;


public class NextSmallerWithSameDigits {

    public static long nextSmaller(long n)
    {
        String strNumber = String.valueOf(n);
        char[] ar = String.valueOf(n).toCharArray();
        int smallerPosition = 0;
        for (int i = 1; i < strNumber.length(); i++)
        {
            if (ar[i-1] > ar[i]) {
                smallerPosition = i;
            }
        }

        long result;
        if (smallerPosition == 0)
        {
            return -1;
        }
        else
        {
            int x = ar[smallerPosition-1];
            int max = smallerPosition;
            int rightSwapPosition = 0;

            for (int j = smallerPosition+1; j < ar.length; j++)
            {
                if (ar[j] < x)
                {
                    rightSwapPosition = j;
                }
            }

            if (rightSwapPosition == 0) {
                swap(ar, smallerPosition, smallerPosition - 1);
            }
            else {
                swap(ar, smallerPosition-1, rightSwapPosition);
            }



            SortDesc(ar, smallerPosition, strNumber.length()-1);
            if (ar[0] == '0') {
                return -1;
            }
            result = Long.parseLong(String.valueOf(ar));
        }
       return result;
    }

    static void swap(char ar[], int i, int j)
    {
        char temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;
    }

    static void SortDesc(char arr[], int i, int j) {
        for (int k = i; k <= arr.length -1; k++) {
            int maxIndex = k;
            for (int l = k; l <= arr.length-1; l++) {
                if (arr[l] > arr[maxIndex]) {
                    maxIndex = l;
                }
            }
            swap(arr, k, maxIndex);
        }
    }

}
