/*

Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

Example:

Given the sorted array: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5
  */

  /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length - 1);        
    }
    
    public TreeNode dfs(int[] nums, int l, int r){
        if(l > r)
            return null;
        TreeNode node = new TreeNode();
        int mid = (l + r)/2;
        node.val = nums[mid];
        node.left = dfs(nums, l, mid-1);
        node.right = dfs(nums, mid + 1, r);
        return node;
    }
}