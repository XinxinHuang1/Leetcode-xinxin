/**
 Given a m * n matrix mat of ones (representing soldiers) and zeros (representing civilians), return the indexes of the k weakest rows in the matrix ordered from the weakest to the strongest.

A row i is weaker than row j, if the number of soldiers in row i is less than the number of soldiers in row j, or they have the same number of soldiers but i is less than j. Soldiers are always stand in the frontier of a row, that is, always ones may appear first and then zeros.
 

Example 1:

Input: mat = 
[[1,1,0,0,0],
 [1,1,1,1,0],
 [1,0,0,0,0],
 [1,1,0,0,0],
 [1,1,1,1,1]], 
k = 3
Output: [2,0,3]
 */

 //Time M * N + M(LogM) --> M * (N + LogM)
//Space O(M)
class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int m = mat.length;
        int n = mat[0].length;
        
        //map rows with number of soldiers
        int[][] records = new int[m][2];
        
        for(int i = 0; i < m; i++){
            int soldiers = 0;
            for(int j = 0; j < n; j++){
                if(mat[i][j] == 0) break;
                soldiers++;
            }
            records[i][0] = i;
            records[i][1] = soldiers;
        }
        Arrays.sort(records, (a, b) -> a[1] == b[1] ? a[0] - b[0] : a[1] - b[1]);
        
        int[] res = new int[k];
        for(int i = 0; i < k; i++){
            res[i] = records[i][0];
        }
        return res;
    }
}