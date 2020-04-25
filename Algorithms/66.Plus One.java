/*

Given a non-empty array of digits representing a non-negative integer, plus one to the integer.

The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.

You may assume the integer does not contain any leading zero, except the number 0 itself.

Example 1:

Input: [1,2,3]
Output: [1,2,4]
Explanation: The array represents the integer 123.
Example 2:

Input: [4,3,2,1]
Output: [4,3,2,2]
Explanation: The array represents the integer 4321.
 */

class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int[] res = new int[n];
        int carry = 1;
        for(int i = n - 1; i >= 0; i--){
            res[i] = (digits[i] + carry) % 10;
            carry = (digits[i] + carry) / 10;
        }
        if(carry == 0)
            return res;
        res = new int[n + 1];
        res[0] = 1;
        return res;
    }
}

//solution 2 
class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for(int i = n - 1; i >= 0; i--){
            if(digits[i] != 9){
                digits[i]++;
                return digits;
            }
            else{
                digits[i] = 0;
            }
        }
        digits = new int[n + 1];
        digits[0] = 1;
        return digits;
    }
}

/*
1 2 9 
1 3 0 

9 9 9
1 0 0 0 
*/