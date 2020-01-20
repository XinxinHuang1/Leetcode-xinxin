/**
 Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

Example 1:

Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
 */


class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        if(nums == null)
            return res;
        res[0] = findFirst(nums, target);
        res[1] = findLast(nums, target);
        return res;
    }
    
    public int findFirst(int[] nums, int target){
        int index = -1, lo = 0, hi = nums.length - 1;
        while(lo <= hi){
            int mid = (lo + hi) / 2;
            if(nums[mid] >= target){
                hi = mid - 1;
            }
            else{
                lo = mid + 1;
            }
            if(nums[mid] == target)
                index = mid;
        }
        return index;
    }
    public int findLast(int[] nums, int target){
        int index = -1, lo = 0, hi = nums.length - 1;
        while(lo <= hi){
            int mid = (lo + hi) / 2;
            if(nums[mid] <= target){
                lo = mid + 1;
            }
            else{
                hi = mid - 1;
            }
            if(nums[mid] == target){
                index = mid;
            }
        }
        return index;
    }
}