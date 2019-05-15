//source: https://leetcode.com/problems/majority-element/
//Easy
//Array
//Date: May 15 2019

/*
Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
You may assume that the array is non-empty and the majority element always exist in the array.

Example 1:
Input: [3,2,3]
Output: 3
Example 2:
Input: [2,2,1,1,1,2,2]
Output: 2
*/



//runtime 1ms, beats 100%, time complexity O(nlgn), space complexity O(1)~O(n)
class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}


//runtime 1024ms, beats 5%
class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        for(int num : nums){
            int count = 0;
            for(int num2 : nums){
                if(num == num2)
                    count += 1;
            }
            if(count > n/2)
            return num;
        }
        return 0;
    }
}






