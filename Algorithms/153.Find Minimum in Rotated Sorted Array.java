/**
 Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).

Find the minimum element.

You may assume no duplicate exists in the array.

Example 1:

Input: [3,4,5,1,2] 
Output: 1
 */

 //Time O(LogN) Space O(1)
class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        
        int l = 0, r = nums.length - 1;

        if(nums[l] < nums[r])
            return nums[l];
        while(l <= r){
            int mid = (l + r)/2;
            if(nums[mid] > nums[mid + 1]){
                return nums[mid+1];
            }
            if(nums[mid - 1] > nums[mid]){
                return nums[mid];
            }
            if(nums[mid] > nums[0]){
                l = mid + 1;
            }
            else{
                r = mid - 1;
            }
        }
        return 0;
    }
}
