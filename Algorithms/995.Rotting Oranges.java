//995.Rotting Oranges - Easy

//Solution 1: BFS
class Solution {
    public int orangesRotting(int[][] grid) {
        
        Queue<int[]>q = new LinkedList<>();
        int row = grid.length;
        int col = grid[0].length;
        int time=-1;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==2){
                    int[] a = new int[] {i,j};//rotten
                    q.add(a);
                }         
            }
        }
        
        //fresh orange gets rotten 
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                int[] a1 = q.poll();
                int r=a1[0];int c = a1[1];
                if(r<=row-2 && grid[r+1][c]==1){
                    grid[r+1][c]=2;
                    q.add(new int[]{r+1,c});
                }
                if(c<=col-2 && grid[r][c+1]==1){
                    grid[r][c+1]=2;
                    q.add(new int[]{r,c+1});
                }
                if(r>=1 && grid[r-1][c] ==1){
                    grid[r-1][c]=2;
                    q.add(new int[]{r-1,c});
                }
                if(c>=1 && grid[r][c-1] ==1){
                    grid[r][c-1]=2;
                    q.add(new int[]{r,c-1});
                }
            }
            time++;
        }
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==1) 
                    return -1;
            }
        }
        if(time==-1) 
            return 0;
        return time;
    }
}

//next page Solution 2



//Solution 2: BFS
class Solution {
    
    int[] dr = new int[]{-1, 0, 1, 0};
    int[] dc = new int[]{0, -1, 0, 1};
   
    public int orangesRotting(int[][] grid) {
        // index of rotten oranges
        int row = grid.length, col = grid[0].length;
        Queue<Integer> q = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == 2){
                    int code = i * col + j;
                    q.add(code);
                    map.put(code,0);
                }
            }
        }
        // fresh orange gets rotten
        int ans = 0;
        while(!q.isEmpty()){
            int code = q.poll();
            int r = code/col, c = code % col;
            for(int k = 0; k < 4; ++k){
                int nr = r + dr[k];
                int nc = c + dc[k];
                if(nr >= 0 && nr < row && nc >= 0 && nc < col && grid[nr][nc] == 1){
                    grid[nr][nc] = 2;
                    int ncode = nr * col + nc;
                    q.add(ncode);
                    map.put(ncode, map.get(code) + 1);
                    ans = map.get(ncode);
                }
            }
        }
        for(int[] R : grid)
            for(int v : R)
                if(v == 1)
                    return -1;
            return ans;
    }
}