/*
Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: ["flower","flow","flight"]
Output: "fl"
Example 2:

Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
*/

//beats 100%
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < strs[0].length(); i++){
            if(common(i, strs))
                sb.append(strs[0].charAt(i));
            else
                break;
        }
        return sb.toString();
    }
    
    public boolean common(int i, String[] strs){
        char c = strs[0].charAt(i);
        for(int j = 1; j < strs.length; j++){
            if(strs[j].length() <= i){
                return false;   
            }
            else if(strs[j].charAt(i) != c)
                return false;
        }
        return true;
    }
}