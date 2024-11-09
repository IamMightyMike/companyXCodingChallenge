# Company X coding challenge

In 2020 I applied for a Software Engineer position at certain tech company and I was faced with this coding challenge.
It consisted of four leetcode-styled exercised.
I have created a bunch of unit tests as well.




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
