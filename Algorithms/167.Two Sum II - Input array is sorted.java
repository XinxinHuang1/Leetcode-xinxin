//source: https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
//Easy
//Array
//Date: May 16 2019

/*
Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.

Note:
Your returned answers (both index1 and index2) are not zero-based.
You may assume that each input would have exactly one solution and you may not use the same element twice.
Example:

Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
*/


//runtime 0ms, beats 100%
class Solution {
    public int[] twoSum(int[] numbers, int target) {
    int l = 0, r = numbers.length -1;
    while(numbers[l] + numbers[r] != target){
        if(numbers[l] + numbers[r] < target)
            l++;
        else
            r--;
    }
        return new int[]{l+1,r+1};
    }
}


//runtime 99ms, beats 5%
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int a = 0, b = 0;
        for(int i = 0; i < numbers.length; i++){
            for(int j = i+1; j < numbers.length; j++){
                if(numbers[i] + numbers[j] == target){
                    a = i+1;
                    b = j+1;
                }
            }
        }
        return new int[]{a,b};
    }
}







