/*
Given n and m which are the dimensions of a matrix initialized by zeros and given an array indices where indices[i] = [ri, ci]. For each pair of [ri, ci] you have to increment all cells in row ri and column ci by 1.

Return the number of cells with odd values in the matrix after applying the increment to all indices.

Input: n = 2, m = 3, indices = [[0,1],[1,1]]
Output: 6
Explanation: Initial matrix = [[0,0,0],[0,0,0]].
After applying first increment it becomes [[1,2,1],[0,1,0]].
The final matrix will be [[1,3,1],[1,3,1]] which contains 6 odd numbers.
 */


 //time: O(n*m)
class Solution {
    public int oddCells(int n, int m, int[][] indices) {
        int[][] matrix = new int[n][m];
        for(int[] index : indices){
            int r = index[0];
            int c = index[1];
            for(int i = 0; i < n; i++){
                matrix[i][c]++;
            }
            for(int j = 0; j < m; j++){
                matrix[r][j]++;
            }
        }
        int res = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(matrix[i][j] % 2 == 1)
                    res++;
            }
        }
        return res;
    }
}