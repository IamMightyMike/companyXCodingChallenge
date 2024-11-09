package com.companyX.codingChallenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class kSubsets {
    public static long kSub(int K, List<Integer> numbers) {

        Integer numberOfBitsInBitMask = (int) Math.pow(2, numbers.size());
        return IntStream.range(1,numberOfBitsInBitMask).mapToObj(i -> {
                    return selectArrayElements(numbers,i);
                }
        ).filter(aSubset -> aSubset.stream().mapToInt(Integer::intValue).sum() % K == 0)
                .count();

    }

    private static List<Integer> selectArrayElements(List<Integer> numbers,int numberMask){

        List<Integer> selectedNumbers = new ArrayList<>();
        IntStream.range(0, numbers.size()).forEach(i -> {
            if((numberMask & 1 << i) != 0) selectedNumbers.add(numbers.get(i));
        });

        return selectedNumbers;
    }
}
