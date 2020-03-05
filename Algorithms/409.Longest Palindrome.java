/*
Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.

This is case sensitive, for example "Aa" is not considered a palindrome here.

Note:
Assume the length of given string will not exceed 1,010.

Example:

Input:
"abccccdd"

Output:
7

Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.
*/

class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c,0) + 1);
        }
        int res = 0;
        for(int val : map.values()){
            res += (val/2) * 2;
        }
        boolean flag = true;
        for(int val : map.values()){
            if(val % 2 == 1 && flag){
                res += 1;
                flag = false;
            }
        }
        return res;
    }
}