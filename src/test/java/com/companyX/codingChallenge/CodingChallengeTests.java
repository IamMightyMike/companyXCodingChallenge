package com.companyX.codingChallenge;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class CodingChallengeTests {


    @Test
    public void testFunWithAnagrams()throws Exception{


        List<String> wordList = Arrays.asList("riptide","code", "doce","ecod","flame", "mefla", "frost","amelf", "pritdie","deco","ipidret");
        List<String> result = FunWithAnagrams.funWithAnagrams(wordList);


        assertEquals(4,result.size());
        assertTrue("code".equals(result.get(0)));
        assertTrue("flame".equals(result.get(1)));
        assertTrue("frost".equals(result.get(2)));
        assertTrue("riptide".equals(result.get(3)));
    }


    @Test
    public void testSMSSplitting()throws Exception{

        int suffixLength = "(1/5)".length();

        String shortMessage = "Hi, Im just writting to say thank you :)";
        List<String> result = SMSSplitting.segments(shortMessage);
        assertEquals(1,result.size());
        assertTrue(shortMessage.equals(result.get(0)));

        String notSoShortMessage = "This is a long long long long SMS message. It is longer than the initial message. It is indeed long. Very long. Very very very long." +
                "Very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very very long.";

        result = SMSSplitting.segments(notSoShortMessage);

        assertEquals(2,result.size());
        assertEquals(160,result.get(0).length());
        assertEquals(notSoShortMessage.length() - 160 + 2*suffixLength,result.get(1).length());

        String actuallyALongMessage = notSoShortMessage + notSoShortMessage;
        result = SMSSplitting.segments(actuallyALongMessage);

        int resultingNumberOfChunks = result.size();
        assertEquals(4,resultingNumberOfChunks);

        Integer totalLength = result.stream().map(aResult -> aResult.length()).reduce((length1,length2) -> length1 + length2).orElse(0);
        assertEquals(actuallyALongMessage.length(),totalLength - resultingNumberOfChunks * suffixLength );

        String messageExceedingLength = notSoShortMessage + notSoShortMessage + notSoShortMessage + notSoShortMessage + notSoShortMessage + notSoShortMessage;
        result = SMSSplitting.segments(messageExceedingLength);

        assertEquals(9 , result.size());
        totalLength = result.stream().map(aResult -> aResult.length()).reduce((length1,length2) -> length1 + length2).orElse(0);
        assertEquals(160 * 9,totalLength );

    }

    @Test
    public void testVanityNumberSearch()throws Exception{

        List<String> numbers = Arrays.asList("+234587264436", "+33356937733","+33356937733", "+8888888888", "+225228522","+1127226311", "+5437676764", "+77996677","+1127226311" ,"+673476465","+887967388","+00225436764200","+634564364","+443245344");
        List<String> vanityCodes = Arrays.asList("FLOWERS","ARCANE","KABUL", "ZYON", "SWORD","EAGLE", "NOTFOUND", "CALIFORNIA");

        List<String> result = VanityNumberSearch.vanity(vanityCodes,numbers);

        assertEquals(7,result.size());
        assertTrue(result.get(0).equals("00225436764200"));
        assertTrue(result.get(1).equals("1127226311"));
        assertTrue(result.get(2).equals("225228522"));
        assertTrue(result.get(3).equals("33356937733"));
        assertTrue(result.get(4).equals("443245344"));
        assertTrue(result.get(5).equals("77996677"));
        assertTrue(result.get(6).equals("887967388"));


    }

    @Test
    public void testKSubarrays()throws Exception{

        List<Integer> numberList = Arrays.asList(5);
        int k = 5;
        assertEquals(1, KSubarrays.kSub(k,numberList));

        numberList = Arrays.asList(5,11);
        k = 5;
        assertEquals(1, KSubarrays.kSub(k,numberList));

        numberList = Arrays.asList(5,11,10);
        k = 5;
        assertEquals(2, KSubarrays.kSub(k,numberList));

        numberList = Arrays.asList(5,10);
        k = 5;
        assertEquals(3, KSubarrays.kSub(k,numberList));

        numberList = Arrays.asList(5,10,15);
        k = 5;
        assertEquals(6, KSubarrays.kSub(k,numberList));

        numberList = Arrays.asList(5,11,10,15);
        k = 5;
        assertEquals(4, KSubarrays.kSub(k,numberList));

        numberList = Arrays.asList(5,11,10,9,15);
        k = 5;
        assertEquals(7, KSubarrays.kSub(k,numberList));

        numberList = Arrays.asList(5,10,11,9,15);
        k = 5;
        assertEquals(10, KSubarrays.kSub(k,numberList));

        numberList = Arrays.asList(5,10,15,11,9);
        k = 5;
        assertEquals(10, KSubarrays.kSub(k,numberList));


    }


}
