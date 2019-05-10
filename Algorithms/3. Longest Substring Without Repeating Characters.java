//source: https://leetcode.com/problems/longest-substring-without-repeating-characters///
// @Xinxin Huang
// 2019-03-09
// Medium

/******************************************************
Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3. 
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3. 
             Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

 ******************************************************/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), a = 0;
        
        Set<Character> set = new HashSet<>();

        int i = 0, j = 0;
        while(i < n && j < n){
            if(!set.contains(s.charAt(i))){
                set.add(s.charAt(i));
                i++;
                a = Math.max(a, i-j);
            }
            else{
                set.remove(s.charAt(j));
                j++;               
            }
        }
        return a;
    }
}
