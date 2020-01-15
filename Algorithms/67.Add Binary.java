
/*
Given two binary strings, return their sum (also a binary string).

The input strings are both non-empty and contains only characters 1 or 0.

Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"
*/


// solution
//time O(MAX(len1, len2)) space O(MAX(len1, len2))
class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int len1 = a.length()-1;
        int len2 = b.length()-1;
        int carry = 0;
        while(len1 >= 0 || len2 >= 0){
            int sum = carry;
            if(len1 >= 0)
                sum += a.charAt(len1--) - '0'; //get int value of char '1' - '0' = 1
            if(len2 >= 0)
                sum += b.charAt(len2--) - '0';
            sb.append(sum % 2);
            carry = sum / 2;
        }
        if(carry == 1)
            sb.append(carry);
        return sb.reverse().toString();
    }
}

// not the solution - time O(N+M)  - limited by length of inputs 
class Solution {
    public String addBinary(String a, String b) {
        //parseInt("30", 2) returns 32, (3)*2^1 + (0)*2^0 = 6
        return Integer.toBinaryString(Integer.parseInt(a,2) + Integer.parseInt(b,2));
    }   
}