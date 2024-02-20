package com.recursion;

import java.util.ArrayList;

public class SubSequenceString {

    public static void main(String[] args) {

        String mainStr = "abc";

        ArrayList<String> subSequences = getSubsequence(mainStr, 0);
        System.out.println(subSequences);

    }

    static ArrayList<String> getSubsequence(String mainString, int index) {
        if (index == mainString.length()) {
            ArrayList<String> strList = new ArrayList<String>();
            strList.add("");
            return strList;
        }
        ArrayList<String> subSq = getSubsequence(mainString, index + 1);
        ArrayList<String> retArrList = new ArrayList<String>();
        // subSq.add("" + mainString.charAt(index - 1));
        char ch = mainString.charAt(index);
        for (String st : subSq) {
            System.out.println(mainString.charAt(index) + "In loop" + st);
            retArrList.add("" + st);
            retArrList.add(ch + st);
        }

        return retArrList;
    }
}
