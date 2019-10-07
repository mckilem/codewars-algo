package com.codewars;

import java.util.Arrays;

public class chromosomeCheck {
        public static String chromosomeCheckFunc(String sperm) {
            // Your code goes here. Have fun!
            String[] sex = sperm.split("");
            if (Arrays.asList(sex).contains("Y"))
            {
                return "Congratulations! You\'re going to have a son.";
            }
            else
            {
                return "Congratulations! You\'re going to have a daughter.";
            }
        }
    public static void main(String[] args){
        chromosomeCheckFunc("XY");
    }
}


