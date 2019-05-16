//source: https://leetcode.com/problems/contains-duplicate/
//Easy
//Array
//Date: May 16 2019

/*
Given an array of integers, find if the array contains any duplicates.
Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
Example 1:
Input: [1,2,3,1]
Output: true

Example 2:
Input: [1,2,3,4]
Output: false

Example 3:
Input: [1,1,1,3,3,4,3,2,4,2]
Output: true

*/


//runtime 3ms, beats 99%
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] == nums[i+1])
                return true;
        }
        return false;
    }
}


//runtime 355ms, beats 5%
class Solution {
    public boolean containsDuplicate(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < n; i++){
            for(int j = i+1; j < n; j++){
                if(nums[i] == nums[j])
                    return true;
            }
        }
        return false;
    }
}






