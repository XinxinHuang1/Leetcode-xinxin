/**
 Given the root node of a binary search tree (BST) and a value to be inserted into the tree, insert the value into the BST. Return the root node of the BST after the insertion. It is guaranteed that the new value does not exist in the original BST.

Note that there may exist multiple valid ways for the insertion, as long as the tree remains a BST after insertion. You can return any of them.

For example, 

Given the tree:
        4
       / \
      2   7
     / \
    1   3
And the value to insert: 5
You can return this binary search tree:

         4
       /   \
      2     7
     / \   /
    1   3 5
This tree is also valid:

         5
       /   \
      2     7
     / \   
    1   3
         \
          4
 */


//Recursion 
//Time O(H), H is tree height, average case O(log N)  worst case O(N)
//Space O(H), average case O(log N), worst case O(N)
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null)
            return new TreeNode(val);
        if(val > root.val)
            root.right = insertIntoBST(root.right, val);
        else
            root.left = insertIntoBST(root.left, val);
        return root;
    }
}

//Iteration
//Time O(H), Space O(1)
class Solution {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root == null)
            return new TreeNode(val);
        
        TreeNode cur = root;
        while(true){
            if(cur.val < val){
                if(cur.right != null){
                    cur = cur.right;
                }
                else{
                    cur.right = new TreeNode(val);
                    break;
                }
            }
            else{
                if(cur.left != null){
                    cur = cur.left;
                }
                else{
                    cur.left = new TreeNode(val);
                    break;
                }
            }
        }
        return root;
    }
}