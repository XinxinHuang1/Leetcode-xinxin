/**
 * Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

Note: A leaf is a node with no children.

Example:

Given binary tree [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
return its depth = 3.
 * 
 * 
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//solution 1: recursion
class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        int L = maxDepth(root.left);
        int R = maxDepth(root.right);
        return Math.max(L, R) + 1;
    }
}
//Time O(N) : visit each node once
//Space: worst case O(N) - tree is completely unbalanced, recursion call occurs N times
//       best case O(Log(N)) - tree is completely balanced, height of tree is Log(N)

//solution2: BFS
class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        
        int depth = 0;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-- > 0){
                TreeNode node = queue.poll();
                if(node.left != null)
                    queue.add(node.left);
                if(node.right != null)
                    queue.add(node.right);
            }
            depth++;
        }
        return depth;
    }
}