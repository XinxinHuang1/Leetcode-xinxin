/**
 Given a binary tree and a sum, determine if the tree has a root-to-leaf path such that adding up all the values along the path equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \      \
7    2      1

return true, as there exist a root-to-leaf path 5->4->11->2 which sum is 22.

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
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null)
            return false;

        int cur = 0;
        return dfs(root, cur, sum);
    }
    
    public boolean dfs(TreeNode root, int cur, int sum){
        cur += root == null ? 0 : root.val;
        
        if(cur == sum && root.left == null && root.right == null)
            return true;
        
        else {
            boolean left = root.left == null ? false : dfs(root.left, cur, sum);
            boolean right = root.right == null ? false : dfs(root.right, cur, sum);
            return left || right;
        }
    }
}