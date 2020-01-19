/**
 Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
Example:
Input: [1,2,3,null,5,null,4]
Output: [1, 3, 4]
Explanation:

   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
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

 //Solution 1 DFS: Time O(N)    Space O(N)
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root == null){
            return res;
        }
        dfs(root, res, 0);// set depth = 0
        return res;
    }
    
    private void dfs(TreeNode root, List<Integer> res, int depth){
        if(root == null){
            return;
        }
        if(depth == res.size()){ // take 1 value from each level/depth
            res.add(root.val);
        }
        // always start from right side
        dfs(root.right, res, depth+1);
        dfs(root.left, res, depth+1);
    }
}

//Solution 2: BFS   Time O(N), Space O(N) - worst case tree is perfectly balanced, add all nodes to the queue
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if(root == null){
            return res;
        }
        
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root); // add first root to queue
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode cur = q.poll();
                if(i == size - 1){ // take the last element of the queue 
                    res.add(cur.val);
                }
                
                // add all values from next level to queue
                if(cur.left != null){
                    q.offer(cur.left);
                }
                if(cur.right != null){
                    q.offer(cur.right); // now queue: 2, 3 take 3 --> next 5, 4 take 4
                }
            }
        }
        return res;
    }
}