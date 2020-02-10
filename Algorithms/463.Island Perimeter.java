/**
 You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water.

Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land cells).

The island doesn't have "lakes" (water inside that isn't connected to the water around the island). One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100. Determine the perimeter of the island.

 

Example:

Input:
[[0,1,0,0],
 [1,1,1,0],
 [0,1,0,0],
 [1,1,0,0]]

Output: 16

 */

class Solution {
    
    final int[][] dirs = {{-1,0},{1,0},{0,1},{0,-1}};
    
    public int islandPerimeter(int[][] grid) {
        int count = 0;
        int m = grid.length, n = grid[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    count += countLen(grid, i, j, m, n);
                }
            }
        }
        return count;
    }
    
    
    public int countLen(int[][] grid, int i, int j, int m, int n){
        int len = 0;
        for(int[] dir : dirs){
            int row = i + dir[0];
            int col = j + dir[1];
            if(row < 0 || row >= m || col < 0 || col >= n)
                len++;
            else if(grid[row][col] == 0)
                len++;
        }
        return len;
    }
}

//solution2 
class Solution {
    public int islandPerimeter(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        int count = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    count += 4;
                    if(i > 0 && grid[i-1][j] == 1) count -= 2;
                    if(j > 0 && grid[i][j-1] == 1) count -= 2;
                }
            }
        }
        return count;
    }
}