package com.companyX.codingChallenge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class kSubsets {
    public static long kSub(int K, List<Integer> numbers) {

        //A binary position in the mask is needed to represent each number in the input array
        Integer numberOfBitsInBitMask = (int) Math.pow(2, numbers.size());

        //Each number from 1, to the computed bitmask would represent a combination of elements from the input array. If a bit in the binary mask is set to 1, then pick its corresponding input number
        //array element. That way, all possible subsets are generated
        return IntStream.range(1,numberOfBitsInBitMask).mapToObj(i -> {
                    return selectArrayElements(numbers,i);
                }
                //For each subset, work out if it is evenly divisible by K
        ).filter(aSubset -> aSubset.stream().mapToInt(Integer::intValue).sum() % K == 0)
                .count();

    }

    /**
     *
     * A method for picking a subset of numbers according to a bitmask.
     *
     * @param numbers
     * @param numberMask
     * @return
     */
    private static List<Integer> selectArrayElements(List<Integer> numbers,int numberMask){


        List<Integer> selectedNumbers = new ArrayList<>();

        //Iterate over the positions in the input array
        IntStream.range(0, numbers.size()).forEach(i -> {
            //Use a bit wise operator to get a 1 trailed by i zeros. Use the bit wise comparison to work out if the i-th position is due to be added to the resulting subset
            if((numberMask & 1 << i) != 0) selectedNumbers.add(numbers.get(i));
        });

        return selectedNumbers;
    }
}
