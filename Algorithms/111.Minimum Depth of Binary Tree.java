/**
 * 
 * Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

Note: A leaf is a node with no children.

Example:

Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
   
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int res = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        if(root == null)
            return 0;
        dfs(root, 0);
        return res;
    }
    
    public void dfs(TreeNode root, int cur){
        if(root == null)
            return;
        cur++;
        if(root.left == null && root.right == null)
            res = Math.min(res, cur);
        else{
            dfs(root.left, cur);
            dfs(root.right, cur);
        }
        return;
    }
}