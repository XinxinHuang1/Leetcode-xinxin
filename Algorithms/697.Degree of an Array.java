/*

Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.

Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.

Example 1:
Input: [1, 2, 2, 3, 1]
Output: 2
Explanation: 
The input array has a degree of 2 because both elements 1 and 2 appear twice.
Of the subarrays that have the same degree:
[1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
The shortest length is 2. So return 2.
Example 2:
Input: [1,2,2,3,1,4,2]
Output: 6 */

class Solution {
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, Integer> firstindex = new HashMap<>();
        HashMap<Integer, Integer> count = new HashMap<>();
        int degree = 0, res = 0;
        for(int i = 0; i < nums.length; i++){
            firstindex.putIfAbsent(nums[i], i);
            count.put(nums[i], count.getOrDefault(nums[i], 0) + 1);
            if(count.get(nums[i]) > degree){
                degree = count.get(nums[i]);
                res = i - firstindex.get(nums[i]) + 1;
            }
            else if(count.get(nums[i]) == degree){
                res = Math.min(res, i - firstindex.get(nums[i]) + 1);
            }
        }
        return res;
    }
}