package com.companyX.codingChallenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SMSSplitting {


    private static final Integer suffixLength = "(1/5)".length();
    private static final Integer maxNumberOfChunks = 9;

    public static List<String> segments(String message){

        //If message is shorter than 160 characters just return it
        if(message.length() <= 160)return Arrays.asList(message);

        //Compute the number of segments. Take into account the length of the suffix
        int numberOfSegments = message.length() / (160 - suffixLength) > maxNumberOfChunks?maxNumberOfChunks:message.length() / (160 - suffixLength);

        List<String> result = new ArrayList<String>();

        //Iterate over the found number of segments and pick the text slices that will make up each segment. Then add the suffix at the end
        result = IntStream.range(0,numberOfSegments).mapToObj(i -> message.substring(i * (160 - suffixLength),(i + 1) * (160 - suffixLength)) + "(" + (i + 1) + "/" + (numberOfSegments) + ")")
                .collect(Collectors.toList());

        //Unless the number of segments exceeds a configured max, add a trailing segment until the message end.
        if(numberOfSegments < maxNumberOfChunks) result.add(message.substring(numberOfSegments * (160 - suffixLength),message.length()) + "(" + (numberOfSegments + 1) + "/" + (numberOfSegments + 1)  + ")");

        return result;

    }

}
