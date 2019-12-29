//source: https://leetcode.com/problems/two-sum////
// @Xinxin Huang
// 2019-03-10
// Easy

/******************************************************

Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].

 ******************************************************/
//Solution 1: Brute Force
class Solution {
    public int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length - 1; i++){
            for(int j = i+1; j < nums.length; j++){
                if(nums[i] == target - nums[j]){
                    return new int[] {i, j};
                }
            }
        }
        return null;
    }
}
// Time Complexity: O(n^2)
// Space Complexity: O(1)

//Solution 2: Hash Table
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(); //hashmap<key, value>
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], i); // key: nums[i], value: i
        }
        
        for(int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            if(map.containsKey(complement) && map.get(complement) != i){
                return new int[] { i, map.get(complement) }; //map.get: return value of a key
            }
        }
        return null;
    }
}
//Time Complexity: O(n)
//Space Complexity: O(n)

//Solution 3: Hash Table
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int complement = target - nums[i];
            if(map.containsKey(complement)){
                return new int[] { i, map.get(complement)};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
//Time Complexity: O(n)
//Space Complexity: O(n)
