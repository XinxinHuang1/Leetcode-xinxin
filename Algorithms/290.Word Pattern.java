/*
Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

Example 1:

Input: pattern = "abba", str = "dog cat cat dog"
Output: true
Example 2:

Input:pattern = "abba", str = "dog cat cat fish"
Output: false
Example 3:

Input: pattern = "aaaa", str = "dog cat cat dog"
Output: false
Example 4:

Input: pattern = "abba", str = "dog dog dog dog"
Output: false
Notes:
You may assume pattern contains only lowercase letters, and str contains lowercase letters that may be separated by a single space.
*/
class Solution {
    public boolean wordPattern(String pattern, String str) {
        HashMap<Character, String> map = new HashMap<>();
        String[] s = str.split(" ");
        if(pattern.length() != s.length) return false;
        
        for(int i = 0; i < s.length; i++){
            char c = pattern.charAt(i);
            String word = s[i];
            if(map.containsKey(c)){
                if(!map.get(c).equals(word))
                    return false;
            }
            else if(map.containsValue(word)){
                return false;
            }
            map.put(c, word);
        }
        return true;
    }
}