/*hard
A group of two or more people wants to meet and minimize the total travel distance. You are given a 2D grid of values 0 or 1, where each 1 marks the home of someone in the group. The distance is calculated usingManhattan Distance, where distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.

For example, given three people living at (0,0), (0,4), and(2,2):

1 - 0 - 0 - 0 - 1
|   |   |   |   |
0 - 0 - 0 - 0 - 0
|   |   |   |   |
0 - 0 - 1 - 0 - 0
The point (0,2) is an ideal meeting point, as the total travel distance of 2+2+2=6 is minimal. So return 6.
*/
//Time O(MN) Space O(N)
class Solution {
    public int minTotalDistance(int[][] grid){
        List<Integer> rows = fillRows(grid);
        List<Integer> cols = fillCols(grid);
        int row = rows.get(rows.size()/2);
        int col = cols.get(cols.size()/2);
        return getDistance(row, rows) + getDistance(col, cols);
    }
    
    public List<Integer> fillRows(int[][] grid){
        List<Integer> rows = new ArrayList<>();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1)
                    rows.add(i);
            }
        }
        return rows;
    }

    public List<Integer> fillCols(int[][] grid){
        List<Integer> cols = new ArrayList<>();
        for(int i = 0; i < grid[0].length; i++){
            for(int j = 0; j < grid.length; j++){
                if(grid[j][i] == 1)
                    cols.add(i);
            }
        }
        return cols;
    }
    public int getDistance(int row, List<Integer> rows){
        int res = 0;
        for(int n : rows){
            res += Math.abs(n - row);
        }
        return res;
    }
}