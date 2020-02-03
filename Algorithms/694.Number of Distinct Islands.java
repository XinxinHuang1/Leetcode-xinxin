

// Time O(M * N) - iterate every element in the grid
// Space O(M * N) - a grid has only 1s 

class Solution{
    /*
    S: start
    O: End
    U: UP
    D: DOWN
    L: LEFT
    R: RIGHT 
    */
    public int numDistinctIslands(int[][] grid){
        if(grid == null || grid.length == 0)
            return 0;
        Set<String> set = new HashSet<>();
        int row = grid.length, col = grid[0].length;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == 1){
                    String path = dfs(grid, i, j, row, col, "S");
                    set.add(path);
                }
            }
        }
        return set.size();
    }

    private String dfs(int[][] grid, int i, int j, int row, int col, String dir){
        if(i < 0 || j < 0 || i >= row || j >= col || grid[i][j] == 0)
            return "O";
        grid[i][j] = 0;
        String left = dfs(grid, i, j-1, row, col, "L");
        String right = dfs(grid, i, j+1, row, col, "R");
        String up = dfs(grid, i-1, j, row, col, "U");
        String down = dfs(grid, i+1, j, row, col, "D");
        return dir + left + right + up + down;
    }

}
