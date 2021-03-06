/*
Given an array of integers nums, write a method that returns the "pivot" index of this array.

We define the pivot index as the index where the sum of the numbers to the left of the index is equal to the sum of the numbers to the right of the index.

If no such index exists, we should return -1. If there are multiple pivot indexes, you should return the left-most pivot index.

Example 1:

Input: 
nums = [1, 7, 3, 6, 5, 6]
Output: 3
Explanation: 
The sum of the numbers to the left of index 3 (nums[3] = 6) is equal to the sum of numbers to the right of index 3.
Also, 3 is the first index where this occurs.*/

class Solution {
    public int pivotIndex(int[] nums) {
        if(nums.length == 0)
            return -1;
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        int left = 0;
        for(int i = 0; i < nums.length; i++){
            int right = sum - nums[i] - left;
            if(left == right)
                return i;
            else
                left += nums[i];
        }
        return -1;
    }
}