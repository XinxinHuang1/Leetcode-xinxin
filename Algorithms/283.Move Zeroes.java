//source: https://leetcode.com/problems/move-zeroes/solution/
//Easy
//Array
//Date: May 15 2019

/*
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
Example:
Input: [0,1,0,3,12]
Output: [1,3,12,0,0]
Note:
You must do this in-place without making a copy of the array.
Minimize the total number of operations.
*/

//runtime 12ms, beats 14%
public class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++){
            if(nums[i] == 0){
                for(int j = i+1; j < n; j++){
                    if(nums[j] != 0){
                        nums[i] = nums[j];
                        nums[j] = 0;
                        break;
                    }
                }
            }
        }
    }
}

//solution 2 0ms, beats 100%
public class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int index = 0;
        for(int i = 0; i < n; i++){
            if(nums[i] != 0){
                nums[index] = nums[i];
                index++;
            }
        }
        for(int i = index; i < n; i++){
            nums[i] = 0;
        }
    }
}




