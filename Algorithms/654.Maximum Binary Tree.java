/*

Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:

The root is the maximum number in the array.
The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
Construct the maximum tree by the given array and output the root node of this tree.

Example 1:
Input: [3,2,1,6,0,5]
Output: return the tree root node representing the following tree:

      6
    /   \
   3     5
    \    / 
     2  0   
       \
        1
*/
//Time worst case O(N ^ 2) Space O(N)
class Solution {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return construct(nums, 0, nums.length);
    }
    
    public TreeNode construct(int[] nums, int l, int r){
        if(l == r)
            return null;
        int max = findMaxIndex(nums, l, r);
        TreeNode root = new TreeNode(nums[max]);
        root.left = construct(nums, l, max);
        root.right = construct(nums, max + 1, r);
        return root;
    }
    
    
    public int findMaxIndex(int[] nums, int l, int r){
        int max = l;
        for(int i = l; i < r; i++){
            if(nums[i] > nums[max])
                max = i;
        }
        return max;
    }
}