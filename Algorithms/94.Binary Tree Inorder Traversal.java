/**
 Given a binary tree, return the inorder traversal of its nodes' values.

Example:

Input: [1,null,2,3]
   1
    \
     2
    /
   3

Output: [1,3,2]
 
* Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        //inorder : left, root, right
        List<Integer> res = new ArrayList<Integer>();
        traverse(root, res);
        return res;
    }
    public void traverse(TreeNode root, List<Integer> res){
        if(root != null){
            if(root.left != null){
                traverse(root.left, res);// add left node first
            }
            res.add(root.val);
            if(root.right != null){
                traverse(root.right, res);
            }
        }
    }
}