
/*
Given a binary tree, return the sum of values of its deepest leaves.

Example 1:
Input: root = [1,2,3,4,5,null,6,7,null,null,null,null,8]
Output: 15

*/
class Solution {
    HashMap<Integer, Integer> map = new HashMap<>();
    public int deepestLeavesSum(TreeNode root) {
        dfs(root, 0);
        int max = -1;
        for(int n : map.keySet()){
            if(n > max)
                max = n;
        }
        return map.get(max);
    }
    
    public void dfs(TreeNode root, int depth){
        if(root == null)
            return;
        map.put(depth, map.getOrDefault(depth, 0) + root.val);
        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
    }
}