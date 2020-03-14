/*
You are given an array of strings words and a string chars.

A string is good if it can be formed by characters from chars (each character can only be used once).

Return the sum of lengths of all good strings in words.

 

Example 1:

Input: words = ["cat","bt","hat","tree"], chars = "atach"
Output: 6
Explanation: 
The strings that can be formed are "cat" and "hat" so the answer is 3 + 3 = 6.
Example 2:

Input: words = ["hello","world","leetcode"], chars = "welldonehoneyr"
Output: 10
Explanation: 
The strings that can be formed are "hello" and "world" so the answer is 5 + 5 = 10.
*/

class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] ch = new int[26];
        for(int i = 0; i < chars.length(); i++){
            ch[chars.charAt(i) - 'a']++;
        }
        int res = 0;
        for(String word : words){
            int[] copy = Arrays.copyOf(ch, ch.length);
            int matched = 0;
            for(char c : word.toCharArray()){
                if(copy[c - 'a'] > 0){
                    copy[c - 'a']--;
                    matched++;
                }
            }
            if(matched == word.length())
                res += word.length();
        }
        return res;
    }
}