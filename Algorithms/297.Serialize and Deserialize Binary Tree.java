/**
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

Example: 

You may serialize the following tree:

    1
   / \
  2   3
     / \
    4   5

as "[1,2,3,null,null,4,5]"
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
public class Codec {
    
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }
    
    private void buildString(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append("null").append(",");
        }
        else{
            sb.append(root.val).append(",");
            buildString(root.left, sb);
            buildString(root.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data == null)
            return null;
        String[] arr = data.split(",");
        Queue<String> queue = new LinkedList<>();
        Collections.addAll(queue, arr);
        return buildTree(queue);
    }
    
    private TreeNode buildTree(Queue<String> queue){
        if(queue.isEmpty())
            return null;
        String s = queue.poll();
        if(s.equals("null"))
            return null;
        TreeNode root = new TreeNode(Integer.parseInt(s));
        root.left = buildTree(queue);
        root.right = buildTree(queue);
        return root;
    }
}
