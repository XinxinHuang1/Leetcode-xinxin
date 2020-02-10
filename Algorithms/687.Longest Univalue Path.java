/**
 Given a binary tree, find the length of the longest path where each node in the path has the same value. This path may or may not pass through the root.

The length of path between two nodes is represented by the number of edges between them.

Example 1:

Input:

              5
             / \
            4   5
           / \   \
          1   1   5
Output: 2
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
    int ans = 0;
    public int longestUnivaluePath(TreeNode root) {
        if(root == null)
            return 0;
        dfs(root);
        return ans;
    }
    public int dfs(TreeNode root){
        if(root == null)
            return 0;
        
        int left = 0, right = 0;
        
        if(root.left != null){
            if(root.left.val == root.val){
                left += dfs(root.left);
            }
            else{
                dfs(root.left);
             }
        }

        if(root.right != null){
            if(root.right.val == root.val){
                right += dfs(root.right);
            }
            else{
                dfs(root.right);
            }
        }

        ans = Math.max(ans, left + right);
        return Math.max(left, right) + 1;
    }
}