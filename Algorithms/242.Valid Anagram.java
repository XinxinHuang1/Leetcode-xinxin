/*
Given two strings s and t , write a function to determine if t is an anagram of s.

Example 1:

Input: s = "anagram", t = "nagaram"
Output: true
Example 2:

Input: s = "rat", t = "car"
Output: false
*/

//Time O(N) Space O(1)
class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length())
            return false;
        int[] map = new int[26];
        for(char c : s.toCharArray()){
            map[c - 'a']++;
        }
        for(char c : t.toCharArray()){
            map[c - 'a']--;
        }
        for(int i : map){
            if(i != 0)
                return false;
        }
        return true;
    }
}