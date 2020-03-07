/*

Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

Each row must contain the digits 1-9 without repetition.
Each column must contain the digits 1-9 without repetition.
Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.

*/

class Solution {
    public boolean isValidSudoku(char[][] board) {
        //rows
        int row = 0;
        while(row < 9){
            HashSet<Character> set = new HashSet<>();
            for(int i = 0; i < 9; i++){
                char cur = board[row][i];
                if(set.contains(cur) && cur != '.')
                    return false;
                set.add(cur);
            }
            row++;
        }
        int col = 0;
        while(col < 9){
            HashSet<Character> set = new HashSet<>();
            for(int i = 0; i < 9; i++){
                char cur = board[i][col];
                if(set.contains(cur) && cur != '.')
                    return false;
                set.add(cur);
            }
            col++;
        }
        int[][] grids = {{0,0}, {0,3}, {0,6}, {3,0}, {6,0},{3,3},{3,6},{6,3},{6,6}};
        for(int[] grid : grids){
            int x = grid[0];
            int y = grid[1];
            HashSet<Character> set = new HashSet<>();
            for(int i = x; i <= x + 2; i ++){
                for(int j = y; j <= y + 2; j++){
                    char cur = board[i][j];
                    if(set.contains(cur) && cur != '.')
                        return false;
                    set.add(cur);
                }
            }   
        }
        return true;
    }
}


// eg. '4' in row 0 encoded as "0(4)"
// '4' in col 0 encoded as "(4)0"
// '4' in top right box encoded as "0(4)2"
class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] != '.'){
                    String a = "(" + board[i][j] + ")";
                    if(!set.add(a + i) || !set.add(j + a) || !set.add(i/3 + a + j/3))
                        return false;
                }
            }
        }
        return true;
    }
}