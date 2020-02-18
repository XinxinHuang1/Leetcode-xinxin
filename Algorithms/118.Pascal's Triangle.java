
/** Easy
 Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it.

Example:

Input: 5
Output:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
 */
//Time O(numRows ^ 2) Space O(numRows ^ 2)
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if(numRows == 0)
            return res;
        
        res.add(new ArrayList<>());
        res.get(0).add(1);
        
        for(int i = 1; i < numRows; i++){
            List<Integer> cur = new ArrayList<Integer>();
            List<Integer> prev = res.get(i-1);
            cur.add(1);
            for(int j = 1; j < i; j++){
                cur.add(prev.get(j-1) + prev.get(j));
            }
            cur.add(1);
            res.add(cur);
        }
        return res;
    }
}

/*
1
1 1
1 2 1 
1 3 3 1 
1 4 6 4 1


*/