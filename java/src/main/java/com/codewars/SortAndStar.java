package com.codewars;

import java.util.Arrays;

public class SortAndStar {

    public static String twoSort(String[] s) {
        Arrays.sort(s);
        System.out.println();
        String str = "";
        for (int i=0; i<s[0].length(); i++) {
            str = str + s[0].charAt(i);
            if (i<s[0].length()-1) {
                str += "***";
            }
        }
        return str;
    }

}