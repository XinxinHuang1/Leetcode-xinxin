/**
 key in the BST. Return the root node reference (possibly updated) of the BST.

Basically, the deletion can be divided into two stages:

Search for a node to remove.
If the node is found, delete the node.
Note: Time complexity should be O(height of tree).

Example:

root = [5,3,6,2,4,null,7]
key = 3

    5
   / \
  3   6
 / \   \
2   4   7

Given key to delete is 3. So we find the node with value 3 and delete it.
 */

//Recursion
//Time O(LogN), Space O(H) -> H = LogN for balanced tree

class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null)
            return root;
        if(root.val > key){
            root.left = deleteNode(root.left, key);
        }
        else if(root.val < key){
            root.right = deleteNode(root.right, key);
        }
        //when root.val == key
        else{
            if(root.left == null)
                return root.right;
            else if(root.right == null)
                return root.left;
            root.val = getMin(root.right);
            root.right = deleteNode(root.right, root.val);
        }
        return root;
    }
    private int getMin(TreeNode root){
        while(root.left != null){
            root = root.left;
        }
        return root.val;
    }
}

