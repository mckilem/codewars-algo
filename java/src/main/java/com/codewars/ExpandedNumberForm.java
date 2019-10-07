package com.codewars;

public class ExpandedNumberForm {
    public static String expandedForm(int num)
    {
        int div = num / 10;
        int mod = num % 10;
        int counter = 0;
        String result = "";
        while ((div!=0) || (mod != 0)) {
            String zeroes = "";
            for (int i=0; i<counter; i++) {
                zeroes += "0";
            }
            String toAdd = "";
            if (mod != 0) {
                toAdd = mod + zeroes;
            }
            result = toAdd + result;
            mod = div % 10;
            div = div / 10;
            if ((mod!=0) && !((div == 0) && (result.equals("")))){
                result = " + " + result;
            }
            counter++;
        }
        return result;
    }
}
