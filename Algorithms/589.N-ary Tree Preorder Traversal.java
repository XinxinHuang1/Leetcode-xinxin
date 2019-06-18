//source: https://leetcode.com/problems/n-ary-tree-preorder-traversal/
//Easy
//Tree
//Date: Jun 18 2019

/*******************************************************************************
Given an n-ary tree, return the preorder traversal of its nodes' values.

For example, given a 3-ary tree:
...（picture）
Return its preorder traversal as: [1,3,5,6,2,4].
**********************************************************************************/


//runtime 1ms, beats 100%
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        if(root == null)
            return result;
        else{
            goThrough(root,result);
        }
        return result;
    }
    
    public void goThrough(Node root, List<Integer> result){
        result.add(root.val);
        if(root.children.isEmpty()){
            return;
        }
        for(Node child : root.children){
            goThrough(child, result);            
        }
    }
}

