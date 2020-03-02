
/*Medium
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its level order traversal as:
[
  [3],
  [9,20],
  [15,7]
] */


//Time O(N) Space O(N)
class Solution {
    HashMap<Integer, List<Integer>> map = new HashMap<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        dfs(root, 0);
        List<List<Integer>> res = new ArrayList<>();
        for(List<Integer> lis : map.values()){
            res.add(lis);
        }
        return res;
    }
    
    public void dfs(TreeNode root, int depth){
        if(root == null)
            return;
        List<Integer> cur = map.get(depth) == null ? new ArrayList<>() : map.get(depth);
        cur.add(root.val);
        map.put(depth, cur);
        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
    }
}