/*
For strings S and T, we say "T divides S" if and only if S = T + ... + T  (T concatenated with itself 1 or more times)

Return the largest string X such that X divides str1 and X divides str2.

Example 1:

Input: str1 = "ABCABC", str2 = "ABC"
Output: "ABC"
Example 2:

Input: str1 = "ABABAB", str2 = "ABAB"
Output: "AB"
Example 3:

Input: str1 = "LEET", str2 = "CODE"
Output: ""
 */
class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if(!(str1+str2).equals(str2+str1))
            return "";
        if(str1.length() < str2.length())
            return gcdOfStrings(str2, str1);
        else if(!str1.startsWith(str1)){
            return "";
        }
        else if(str2.isEmpty())
            return str1;
        else
            return gcdOfStrings(str1.substring(str2.length()), str2);
    }
}

//faster beats 100%
class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if(!(str1+str2).equals(str2+str1))
            return "";
        int len1 = str1.length();
        int len2 = str2.length();
        int gcd = helper(len1, len2);
        return str1.substring(0, gcd);
    }
    
    public int helper(int a, int b){
        if(b == 0)
            return a;
        else 
            return a % b == 0 ? b : helper(b, a % b);
    }
}