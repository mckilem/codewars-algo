package com.codewars;

public class DnaStrand {
    public static String makeComplement(String dna) {
        String dnaNew = "";
        for (int i=0; i<dna.length(); i++) {
            dnaNew += getLetter(dna.charAt(i));
        }
        return dnaNew;
    }

    static char getLetter(char a) {
        char c = 'A';
        if (a == 'A') {
            c = 'T';
        }
        if (a == 'T') {
            c = 'A';
        }
        if (a == 'C') {
            c = 'G';
        }
        if (a == 'G') {
            c = 'C';
        }
        return c;
    }
}
