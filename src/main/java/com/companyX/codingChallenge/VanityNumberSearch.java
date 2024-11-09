package com.companyX.codingChallenge;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class VanityNumberSearch {


    public static List<String> vanity(List<String> codes, List<String> numbers){

        //Strip the "+" from the numbers in the param list
        List<String> numbersWithoutPlus = numbers.stream().map(number->number.replace("+","")).collect(Collectors.toList());

        //Convert each vanity code to its equivalent numeric code
        List<String>convertedVanityCodes = codes.stream().map(VanityNumberSearch::VanityToNumber).collect(Collectors.toList());

        Set<String> duplicateControl = new HashSet<String>();

        //Filter out duplicate numbers from the param list, then keep those numbers that contain a converted vanity code
        List<String> result = numbersWithoutPlus.stream().filter(number -> duplicateControl.add(number))
                .filter(number -> convertedVanityCodes.stream().anyMatch(convertedVanityCode -> number.contains(convertedVanityCode))).collect(Collectors.toList());

        //Sor the resulting list
        Collections.sort(result);
        return result;
    }

    //Simple method that maps a vanity code to its equivalent characters
    private static String VanityToNumber(String vanityCode){

        return vanityCode.chars().mapToObj(asciiChar -> {

            if(Set.of(65,66,67).contains(asciiChar))return "2";
            else if(Set.of(68,69,70).contains(asciiChar))return "3";
            else if(Set.of(71,72,73).contains(asciiChar))return "4";
            else if(Set.of(74,75,76).contains(asciiChar))return "5";
            else if(Set.of(77,78,79).contains(asciiChar))return "6";
            else if(Set.of(80,81,82,83).contains(asciiChar))return "7";
            else if(Set.of(84,85,86).contains(asciiChar))return "8";
            else if(Set.of(87,88,89,90).contains(asciiChar))return "9";
            else return "";
        }).collect(Collectors.joining());
    }
}
