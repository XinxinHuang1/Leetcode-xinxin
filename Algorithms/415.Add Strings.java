/**
 Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.

 input : "11" "22"
 outpur: "33"
 */

class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int len1 = num1.length();
        int len2 = num2.length();
        while(len1 > 0 || len2 > 0 || carry == 1){
            int x = len1 <= 0 ? 0 : num1.charAt(len1 -1) - '0';
            int y = len2 <= 0 ? 0 : num2.charAt(len2 -1) - '0';
            sb.append ((x + y + carry) % 10);
            carry = (x + y + carry)/ 10;
            len1--;
            len2--;
        }
        return sb.reverse().toString();
    }
}