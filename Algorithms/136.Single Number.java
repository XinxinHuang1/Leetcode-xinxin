
/*
Given a non-empty array of integers, every element appears twice except for one. Find that single one.

Note:

Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Example 1:

Input: [2,2,1]
Output: 1
Example 2:

Input: [4,1,2,1,2]
Output: 4
 */

 //Time O(N) Space O(1)
class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for (int i : nums)
        { 
            //Exclusive OR (XOR) 
            //results in 1 only if both the compared bits have a different value, otherwise, it results in 0.
            res ^= i;           
        }
        return res;
    }
}
