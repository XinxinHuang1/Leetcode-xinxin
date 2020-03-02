/*
Given two strings s and t, determine if they are isomorphic.

Two strings are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character but a character may map to itself.

Example 1:

Input: s = "egg", t = "add"
Output: true
Example 2:

Input: s = "foo", t = "bar"
Output: false
Example 3:

Input: s = "paper", t = "title"
Output: true
*/


//array instead of map
class Solution {
    public boolean isIsomorphic(String s, String t) {
        int[] m1 = new int[256];
        int[] m2 = new int[256];
        int n = s.length();
        for(int i = 0; i < n; i++){
            if(m1[s.charAt(i)] != m2[t.charAt(i)])
                return false;
            m1[s.charAt(i)] = i + 1;
            m2[t.charAt(i)] = i + 1;
        }
        return true;
    }
}

//hashmap
class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> m1 = new HashMap<>();
        HashMap<Character, Character> m2 = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if(m1.containsKey(c1)){
                if(c2 != m1.get(c1))
                    return false;
            }
            else{
                if(m2.containsKey(c2)){
                    return false;
                }
                m1.put(c1, c2);
                m2.put(c2, c1);
            }
        }
        return true;
    }
}