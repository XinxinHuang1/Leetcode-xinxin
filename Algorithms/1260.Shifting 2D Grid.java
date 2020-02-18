/** Easy
 Given a 2D grid of size m x n and an integer k. You need to shift the grid k times.

In one shift operation:

Element at grid[i][j] moves to grid[i][j + 1].
Element at grid[i][n - 1] moves to grid[i + 1][0].
Element at grid[m - 1][n - 1] moves to grid[0][0].
Return the 2D grid after applying shift operation k times.

Example 1:

Input: grid = [[1,2,3],[4,5,6],[7,8,9]], k = 1
Output: [[9,1,2],[3,4,5],[6,7,8]]
 */

class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] shifted = new int[row][col];
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                int j2 = (j + k) % col;
                int i2 =  ((j + k) / col + i) % row;
                shifted[i2][j2] = grid[i][j];
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < row; i++){
            List<Integer> eachRow = new ArrayList<>();
            for(int j = 0; j < col; j++){
                eachRow.add(shifted[i][j]);            
            }
            res.add(eachRow);
        }
        return res;
    }
}