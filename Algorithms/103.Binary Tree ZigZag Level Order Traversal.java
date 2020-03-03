
/*Medium
Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree [3,9,20,null,null,15,7],
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
 */
class Solution {
        
    HashMap<Integer, List<Integer>> map = new HashMap<>();

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        dfs(root, 0);
        List<List<Integer>> res = new ArrayList<>();
        for(int i : map.keySet()){
            if(i % 2 == 0)
                res.add(map.get(i));
            else
                res.add(reverse(map.get(i)));
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
    
    public List<Integer> reverse(List<Integer> list){
        
        List<Integer> res = new ArrayList<>();
        for(int i = list.size() - 1; i >= 0; i--){
            res.add(list.get(i));
        }
        return res;
    }
}