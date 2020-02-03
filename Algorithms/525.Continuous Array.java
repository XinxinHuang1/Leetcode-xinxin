/**
 Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.

Example 1:
Input: [0,1]
Output: 2
Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
 */



//Brute Force: Time Limit Exceeded
//Time O(n^2) Space O(1)
class Solution {
    public int findMaxLength(int[] nums) {
        int max = 0, n = nums.length;
        for(int i = 0; i < n; i++){
            int zeros = 0, ones = 0;
            for(int j = i; j < n; j++){
                if(nums[j] == 0)
                    zeros++;
                else
                    ones++;
                if(zeros == ones)
                    max = Math.max(max, zeros+ones);
            }
        }
        return max;
    }
}