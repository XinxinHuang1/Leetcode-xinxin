/*
Find the sum of all left leaves in a given binary tree.

Example:

    3
   / \
  9  20
    /  \
   15   7

There are two left leaves in the binary tree, with values 9 and 15 respectively. Return 24. */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 //beats 100%
class Solution {
    int sum = 0;
    public int sumOfLeftLeaves(TreeNode root) {
        dfs(root);
        return sum;
    }
    public void dfs(TreeNode root){
        if(root == null)
            return;
        if(root.left != null && root.left.left == null && root.left.right == null)
            sum += root.left.val;
        dfs(root.left);
        dfs(root.right);
    }
}
