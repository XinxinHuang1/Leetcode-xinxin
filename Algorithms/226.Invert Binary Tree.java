//source: https://leetcode.com/problems/invert-binary-tree/
//Easy
//Tree
//Date: Jun 18 2019

/*******************************************************************************
Invert a binary tree.
Example:
Input:

     4
   /   \
  2     7
 / \   / \
1   3 6   9
Output:

     4
   /   \
  7     2
 / \   / \
9   6 3   1
**********************************************************************************/


//runtime 0ms, beats 100%
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
    public TreeNode invertTree(TreeNode root) {
        if(root == null)
            return null;
        else{
            TreeNode right = invertTree(root.right); //invertTree() make sure the last line is reversed
            TreeNode left = invertTree(root.left);
            root.right = left;
            root.left = right;
        }
        return root;
    }
}

