/*
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.
Example 2:

Input: "cbbd"
Output: "bb"
*/


//Time O(N^2) expanding round takes O(N) time
//Space O(1)
class Solution {
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0)
            return "";
        int index = 0, max = 0;
        for(int i = 0; i < s.length(); i++){
            int len1 = extend(s, i, i);
            int len2 = extend(s, i, i+1);
            if(max < Math.max(len1, len2)){
                max = Math.max(len1, len2);
                index = len1 > len2 ? i - len1/2 : i - len2/2 + 1;
            }
        }
        return s.substring(index, index + max);
    }
    //extend around center
    public int extend(String s, int l, int r){
        while(l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)){
            l--;
            r++;
        }
        return r - l - 1;//r - l + 2 - 1  two unmatched char
    }
}

// 0 1 2 3 4 
// c b b a d    i = 3, l = 1 r = 5 max = 3 index = 3 - 1 = 2 return substring(2, 5)