package com.companyX.codingChallenge;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class KSubarrays {

    public static long kSub(int K,List<Integer> numbers) {

        return IntStream.range(0,numbers.size()).mapToObj(i -> {

            //Compute every possible subarray by first iterating the would-be beginning of each subarray, and for each, iterate the remainder elements until the last. Pick the resulting slice
            //at each step and check that the sum is divisible with zero modulus by K.
            return IntStream.range(i, numbers.size() + 1)
                    .mapToObj(j -> numbers.subList(i, j))
                    .filter(sublist -> !sublist.isEmpty() && sublist.stream().mapToInt(Integer::intValue).sum() % K == 0)
                    .count(); //Return the count of k-subarrays found at this iteration of i

            //Sum and return the count of each iteration ofi
        }).reduce((count1,count2) -> count1 + count2).orElse(0L);
    }

}
