# Company X coding challenge

In 2020 I applied for a Software Engineer position at certain tech company and I was faced with this coding challenge.
It consisted of four leetcode-styled exercised.

I figured that I´d solve them four years later and share the solutions. 
I have created a bunch of unit tests as well that enable the functions to be invoked and tested.




## 1. Fun with anagrams

Two strings are anagrams if they are permutations of each other. In other words, both strings have the same size and the same characters. For example, "aaagrmns" is an anagram of "anagrams". Given an array of strings, remove each string that is an anagram of an earlier string, then return the remaining array in sorted order

**Example**
str = [`code`,`doce`,`ecod`,`farmer`,`frame`]
Should return ['code,'farmer','frame']

Complete the function *funWithAnagrams* 
*funWithAnagrams* has the following parameters:

 - string text[n]: an array of strings
Returns:
 - string [m]: an array of the remaining strings in ascending alphabetical order.

**Constraints**

 - 0 <= n <= 1000
 - 0 <= m <= n
 - 1 <= length of text[i] <= 1000
 - Each string text[i] is made up of characters in the range ascii[a-z].

## 2. SMS Splitting
Given an input string of arbitrary length, output SMS-compliant segments with suffixes

 - A SMS-Compliant segment is of length 160 characters or less
 - Do not generate segmens if the input fits in a single message
 - A segment suffix looks like "(1/5)" for the first of five segments.
 - The segment content and suffix must both fit in the segment

**Function description**
Complete the function/method stub to return an array of message segments given a message as input

**Constraints**

 - Inputs will only consist if A-Z, a-z, spaecs ( ), commas (,) and periods (.)
 - Your implementation can expect a maximum of 9 segments per input

## 3. Vanity Number Search

Company X´s customers sometimes request to purchase vanity phone numbers. These vanity numbers are designed to be unique to the customer´s brand and memorable to their end users. An example of this is 1-800-FLOWERS, which translates to 1-800-3569377.
Here, each letter in the vanity code (FLOWERS) corresponds to a digit on the T9 keypad map, so, F would map to 3, L to 5, O to 6 and so on, resulting in 3569377.
Customers typically search Company X´s phone number inventory for such vanity codes.

![T9 keypad map](https://upload.wikimedia.org/wikipedia/commons/thumb/7/73/Telephone-keypad2.svg/220px-Telephone-keypad2.svg.png)

Given an array of one or more vanity codes and an array of phone numbers, write a function to find all phone numbers that match one or more vanity codes. The output must be a sorted array of unique phone numbers from the input array of numbers.

**Function description**
Complete the function vanity. 
Vanity has the following parameters:

 - codes[codes[0],... codes[c-1]]: an array of strings (vanity codes)
 - numbers[numbers[0],..., numbers[n-1]]: an array of strings (phone numbers)

**Constraints**

 - The input numbers array may have repeted elements
 - The output must be a sorted array of unique numbers
 - Vanity codes will only consist of uppercase letters (A-Z)
 - All vanity codes will be shorter in length than all phone numbers
 - The output array should be a subset of the input array of phone numbers
 - Vanity codes can appear anywhere in the number, including country or area codes.
 - Phone numbers will be in the E.164 format i.e. a plus (+) followed by up to 15 digits (0-9).


## 4. K-Subarrays

A *k-subarray* of an array is defined as follows:

 - It is a subarray, i.e. made of contiguous elements from the original array.
 - The sum of the subarray elements must be evenly divisible by k, i.e. sum mod k = 0

Given an array of integers, determine the number of k-subarrays it contains. For example, given *k=5* and the array *nums=[5,10,11,9,5]*, its k-subarrays would be: *{5}, {5,10}, {5,10,11,9}, {5,10,11,9,5}, {10}, {10,11,9}, {10,11,9,5}, {11,9}, {11,9,5}, {5}*

**Function Description**
Complete the function *kSub*.
The function must return a long integer representing the number of *k-subarrays* in the array.
*kSub* has the following parameters:

 - k: the integer divisor of a *k-subarray*
 - nums[nums[0],... nums[n-1]]: an array of integers


## Bonus Stage: K-subsets

When I took the test I missread the requirements for the *k-subarrays* exercise and attempted to evaluate is subsets rather than its subarrays. A subset would be a bunch of not necesarily contiguous elements from the original array picked in any order. 
Needless to say, I failed miserably to solve this variant of the exercise, as it is a much tougher problem. Anyhow, I thought it would be fun to solve it and share the solution :)
