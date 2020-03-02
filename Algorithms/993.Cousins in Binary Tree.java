/*
In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.

Two nodes of a binary tree are cousins if they have the same depth, but have different parents.

We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.

Return true if and only if the nodes corresponding to the values x and y are cousins.
*/


//Time O(N) Space O(N)
class Solution {
    //use treeNode instead of integer to avoid put null in dfs
    HashMap<Integer, TreeNode> parmap = new HashMap<>();
    HashMap<Integer, Integer> depth = new HashMap<>();
    public boolean isCousins(TreeNode root, int x, int y) {
        
        if(root == null || root.left == null || root.right == null)
            return false;
        dfs(root, null);
        if((parmap.get(x) != parmap.get(y)) && depth.get(x) == depth.get(y))
            return true;
        
        return false;
    }
    
    public void dfs(TreeNode root, TreeNode parent){
        if(root == null)
            return;
        depth.put(root.val, parent == null ? 0 : depth.get(parent.val) + 1);
        parmap.put(root.val, parent);
        dfs(root.left, root);
        dfs(root.right, root);
    }
}