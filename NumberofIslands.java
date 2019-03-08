//source: https://leetcode.com/problems/number-of-islands//
// @Xinxin Huang
// 2019-03-08
// Medium

/******************************************************
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. 
An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input:
11110
11010
11000
00000

Output: 1

Example 2:

Input:
11000
11000
00100
00011

Output: 3

 ******************************************************/
class Solution {
    
    public int numIslands(char[][] grid) {
            
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        
        int count = 0;
        final int rows = grid.length;
        final int cols = grid[0].length;
        
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(grid,i,j,rows,cols);
                }
            }
        }
        return count;
    }
    
    final static int[][] dirs = {{-1,0},{1,0},{0,-1},{0,1}};  //move to left, right, down, up
    private void dfs(char[][] grid, int x, int y, int rows, int cols){
        if(x < 0 || x >= rows || y < 0 || y >= cols || grid[x][y] == '0'){
            return;
        }
        grid[x][y] = '0';      //mark visited place as 0
        for(int[] dir : dirs){
            int neighborX = dir[0] + x; //find neighbors in four directions
            int neighborY = dir[1] + y;
            dfs(grid,neighborX, neighborY,rows,cols);
        }
    }
}

