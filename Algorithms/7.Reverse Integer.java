//source:https://leetcode.com/problems/reverse-integer/
//Easy #Amazon
//Date: Jul 12 2019

/*
Given a 32-bit signed integer, reverse digits of an integer.

Example 1:

Input: 123
Output: 321
Example 2:

Input: -123
Output: -321
Example 3:

Input: 120
Output: 21
Note:
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
*/

//runtime 1ms, beats 100%
class Solution {
    public int reverse(int x) {
        int ans = 0;
        while(x != 0){
            int pop = x % 10;  //123 -> pop = 12 -> pop = 1
            x /= 10; //x = 3 x = 2 x = 1
        if(ans > Integer.MAX_VALUE/10 || (ans == Integer.MAX_VALUE/10 && pop > 7))
            return 0; // if ans > integer.maxvalue /10, causes overflow
        if(ans < Integer.MIN_VALUE/10 || (ans == Integer.MIN_VALUE/10 && pop < -8))
            return 0;
        ans = ans * 10 + pop; 
        }
        return ans;
    }
}

