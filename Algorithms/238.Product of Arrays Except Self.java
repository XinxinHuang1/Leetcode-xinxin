//238. Product of Arrays Except Self
/*Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Example:

Input:  [1,2,3,4]
Output: [24,12,8,6]
Note: Please solve it without division and in O(n).*/


// Solution 1: Multiply by left and multiply by right //Time: O(N), Space: O(N)
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        
        left[0] = 1;
        for(int i = 1; i < n; i++){
            left[i] = nums[i-1] * left[i-1];
        }
        
        right[n-1] = 1;
        for(int i = n-2; i >= 0; i--){
            right[i] = nums[i+1] * right[i+1];
        }
        
        int ans[] = new int[n];
        for(int i = 0; i < n; i++){
            ans[i] = left[i] * right[i];
        }
        return ans;
    }
}

//Solution 2: same idea as solution 1  // Time O(N), Space O(1)
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        
        ans[0] = 1;
        for(int i = 1; i < n; i++){
            ans[i] = ans[i-1] * nums[i-1];
        }
        
        int R = 1;
        for(int i = n-1; i >= 0; i--){
            ans[i] = ans[i] * R;
            R *= nums[i];
        }
        return ans;
    }
}
