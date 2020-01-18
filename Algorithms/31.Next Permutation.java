/*
Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place and use only constant extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.

1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1
*/

class Solution {
    public void nextPermutation(int[] nums) {
        // increasing first (make sure greater than original) and then decreasing(smaller than original)
        // 1, 3, 5, 8, 7  
        // 1, 3, 7, 8, 5
        // 1, 3, 7, 5, 8
        int n = nums.length;
        int i = n - 2;
        
        //right to left index of decrease -> first high point left to right
        while(i >= 0 && nums[i] >= nums[i+1]){  // i = 3, val = 8
            i--; // i = 2, val = 5
        }
        // right to i index of decrease - > first high point i to right
        if(i >= 0){
            int j = n - 1;
            while(j > i && nums[j] <= nums[i]){  // j = 4
                j--; // j = 3, val = 8
            }
            swap(nums, i, j);
        }
        reverse(nums, i+1, n-1);
        
    }
    
    private void swap(int[] nums, int lo, int hi){
        int temp = nums[lo];
        nums[lo] = nums[hi];
        nums[hi] = temp;
    }
    
    private void reverse(int[] nums, int lo, int hi){
        while(lo < hi){
            swap(nums, lo++, hi--);
        }
    }
}