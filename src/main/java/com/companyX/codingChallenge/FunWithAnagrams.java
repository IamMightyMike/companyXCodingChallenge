package com.companyX.codingChallenge;

import java.util.*;

public class FunWithAnagrams {


    public static List<String> funWithAnagrams(List<String> text){

        Set<Integer> charSumSet = new HashSet<Integer>();
        List<String> result = new ArrayList<String>();

        //For each string compute the sum of the ASCII code of its characters. Use a Set to check for duplicate counts. Should a certain count be already present in the set, then, don´t add
        //that work to the resulting list, as it is an anagram of an already seen string
        text.forEach(aString ->{
                    if(charSumSet.add(aString.chars().sum()))result.add(aString);
                }
        );

        //Sort the resulting list
        Collections.sort(result);
        return result;
    }

}
