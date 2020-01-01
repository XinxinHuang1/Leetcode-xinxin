//572. SubTree of Another Tree

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

 //Solution 1: Comparison of Nodes
class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
       return s != null && (equals(s,t) || isSubtree(s.left, t) || isSubtree(s.right, t));
    }
    
    public boolean equals(TreeNode a, TreeNode b){
        if(a == null && b == null)
            return true;
        if(a == null || b == null)
            return false;
        return a.val == b.val && equals(a.left, b.left) && equals(a.right, b.right);
    }
}
// Time: O(m * n)  --  total of n nodes of s and m nodes of t are traversed
// Space: O(n) n- number of nodes in s

//Solution 2: Preorder Traversal
class Solution {

    public boolean isSubtree(TreeNode s, TreeNode t) {
        String tree1 = preorder(s, true);
        String tree2 = preorder(t, true);
        return tree1.indexOf(tree2) >= 0;
    }
    
    public String preorder(TreeNode a, boolean b){
        if(a == null){
            if(b)
                return "lnull";
            else
                return "rnull";
        }
        return '#' + a.val + " " + preorder(a.left, true) + " " + preorder(a.right, false);
    }
}
//Time: O(m^2 + n^2 + m * n)  
//Space: O(Max(m,n))