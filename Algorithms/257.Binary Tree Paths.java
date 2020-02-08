/**
 Given a binary tree, return all root-to-leaf paths.

Note: A leaf is a node with no children.

Example:

Input:

   1
 /   \
2     3
 \
  5

Output: ["1->2->5", "1->3"]

Explanation: All root-to-leaf paths are: 1->2->5, 1->3

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
    
    List<String> res = new ArrayList<String>();
    
    public List<String> binaryTreePaths(TreeNode root) {      
        dfs(root, "");
        return res;
    }
    
    public void dfs(TreeNode root, String path){
        if(root == null)
            return;
        if(root.left == null && root.right == null){
            res.add(path + root.val);
            return;
        }
        path = path + root.val + "->";
        dfs(root.left, path);
        dfs(root.right, path);
    }
}