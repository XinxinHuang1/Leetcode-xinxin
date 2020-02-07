/**
 Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
 

But the following [1,2,2,null,3,null,3] is not:

    1
   / \
  2   2
   \   \
   3    3

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

 //Time O(N) Space O(N)
class Solution {
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        return helper(root.left, root.right);
    }
    
    public boolean helper(TreeNode a, TreeNode b){
        if((a == null && b != null) || (a != null && b == null))
            return false;
        if(a == null && b == null)
            return true;
        if(a.val != b.val)
            return false;
        else{
            return helper(a.left, b.right) && helper(a.right, b.left);
        }
    }
}