/*
76. Minimum Window Substring - Hard

Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

Example:

Input: S = "ADOBECODEBANC", T = "ABC"
Output: "BANC"
*/

class Solution {
    public String minWindow(String s, String t) {
        if(s.length() < t.length())
            return "";
        
        // key: unique chars, value: number of chars
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(char ch : t.toCharArray()){
            Integer count = map.get(ch);
            if(count == null){
                map.put(ch, 1);
            }
            else{
                map.put(ch, count + 1);
            }
        }
        
        // index: window left index
        int slow = 0, minLen = Integer.MAX_VALUE, matchCount = 0, index = 0;
        for(int fast = 0; fast < s.length(); fast++){
            char ch = s.charAt(fast);
            Integer count = map.get(ch);
            if(count == null){
                continue;
            }
            map.put(ch, count - 1); //the need for matched char - 1;
            if(count == 1){
                matchCount++; // the count of chars that are matched (in map from 1 to 0)
            }
            
            
            // find window
            while(matchCount == map.size()){ // all chars are matched -> forms a window
                //update window to shortest
                if(fast - slow + 1 < minLen){
                    minLen = fast - slow + 1;
                    index = slow; //index : start of the window
                }
                // update start of the window, see if can find shorter window
                char leftmost = s.charAt(slow++);
                Integer leftmostCount = map.get(leftmost);
                if(leftmostCount == null){ //doesn't need the char
                    continue;
                }
                
                //if the leftmost char exists in t, move forward, update needed char by + 1
                map.put(leftmost, leftmostCount + 1); //removed the char, need + 1;
                if(leftmostCount  == 0){
                    matchCount--;
                }
            }
            
        }
        //edge case: minLen should not be equal to MAX_VALUE
        return minLen == Integer.MAX_VALUE ? "" : s.substring(index, index + minLen);
    }
}


