package com.codewars;

import java.util.HashMap;
import java.util.Set;

class LongestConsec {

    public static String longestConsec(String[] strarr, int k) {
        String res = "";
        if (strarr.length < k || strarr.length ==0 || k <= 0) { return ""; };
        HashMap<String,Integer> dict = new HashMap<String,Integer>();
        for (int i=0; i< strarr.length; i++) {
            dict.put(strarr[i], strarr[i].length());
        }
        for (int i=0; i < k; i++) {
            String tmp = getmax(dict);
            dict.remove(tmp);
            res = res + tmp;
        }

        return res;
    }

    public static String getmax(HashMap<String, Integer> dict) {
        int max = Integer.MIN_VALUE;
        String res = "";
        Set<String> keys = dict.keySet();
        for (int i=0; i<keys.size(); i++) {
            int len = dict.get(keys.toArray()[i]);
            if (len > max) {
                max = len;
                res = (String)keys.toArray()[i];
            }
        }
        return res;
    }
}
