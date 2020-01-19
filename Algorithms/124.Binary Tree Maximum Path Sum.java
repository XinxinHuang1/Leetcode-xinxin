
/**
 Given a non-empty binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.

Example 1:

Input: [1,2,3]

       1
      / \
     2   3

Output: 6
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
    public int maxPathSum(TreeNode root) {
        //corner case
        if(root == null){
            return 0;
        }
        
        // save max value
        // why int[] not int - java guarantee pass by value, if it's int it can't be updated 
        // so that we can keep updating original int[] maxSum
        int[] maxSum = new int[]{Integer.MIN_VALUE};
        dfs(root, maxSum);
        return maxSum[0];
    }
    
    //use root as highest point, return max sum of all its paths
    private int dfs(TreeNode root, int[] maxSum){

        // if node is leaf node(no child) take 0
        // if value < 0, don't add to sum
        int left = root.left != null ? Math.max(dfs(root.left, maxSum),0) : 0;
        int right = root.right != null? Math.max(dfs(root.right, maxSum),0) : 0;
                                                 
        //calculate max sum of root
        int cur = root.val + left + right;
        maxSum[0] = Math.max(maxSum[0], cur);
        return root.val + Math.max(left, right);

    }
}