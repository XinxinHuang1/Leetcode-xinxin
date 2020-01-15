/*
Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

Example 1:
Input:nums = [1,1,1], k = 2
Output: 2
*/


//Solution1: Hashmap, distance of two subarrays is the sum of one subarray
// Time O(N)  Space O(1)
class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        map.put(0,1);
        
        for(int num : nums){
            sum += num;
            if(map.containsKey(sum - k)){
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}

//Solution 2: Iterate   
//Time O(N^2)   Space O(1)
class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        
        for(int i = 0; i < nums.length; i++){
            int sum = nums[i];
            if(sum == k)
                count++;
            for(int j = i + 1; j < nums.length; j++){
                sum += nums[j];
                if(sum == k)
                    count++;
            }
        }
        return count;
    }
}


//Solution 3: Brute Force 
// Time (O(N^3))    space O(1)
class Solution {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        int[] sum = new int[nums.length + 1];
        sum[0] = 0;
        
        for(int i = 1; i <= nums.length; i++){
            sum[i] = sum[i-1] + nums[i-1];
        }
        
        for(int start = 0; start < nums.length; start++){
            for(int end = start + 1; end <= nums.length; end++){
                if(sum[end] - sum[start] == k)
                    count++;
            }
        }
        return count;
    }
}