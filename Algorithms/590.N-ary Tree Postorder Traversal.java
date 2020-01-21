/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

// 1: Recursive
class Solution {
    
    List<Integer> res = new ArrayList<Integer>();
    public List<Integer> postorder(Node root) {
        if(root == null)
            return res;
        
        for(Node node : root.children){
            postorder(node);
        }
        
        res.add(root.val);
        
        return res;
    }
}

// 2: Iterate
class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root == null)
            return res;
        
        Stack<Node> stack = new Stack<Node>();
        stack.add(root);
        while(!stack.isEmpty()){
            root = stack.pop();
            res.add(root.val);
            for(Node node : root.children)
                stack.add(node);
        }
        Collections.reverse(res);
        return res;
    }
}

