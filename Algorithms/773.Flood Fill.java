/**Easy
 * An image is represented by a 2-D array of integers, each integer representing the pixel value of the image (from 0 to 65535).

Given a coordinate (sr, sc) representing the starting pixel (row and column) of the flood fill, and a pixel value newColor, "flood fill" the image.

To perform a "flood fill", consider the starting pixel, plus any pixels connected 4-directionally to the starting pixel of the same color as the starting pixel, plus any pixels connected 4-directionally to those pixels (also with the same color as the starting pixel), and so on. Replace the color of all of the aforementioned pixels with the newColor.

At the end, return the modified image.

Example 1:
Input: 
image = [[1,1,1],[1,1,0],[1,0,1]]
sr = 1, sc = 1, newColor = 2
Output: [[2,2,2],[2,2,0],[2,0,1]]
Explanation: 
From the center of the image (with position (sr, sc) = (1, 1)), all pixels connected 
by a path of the same color as the starting pixel are colored with the new color.
Note the bottom corner is not colored 2, because it is not 4-directionally connected
to the starting pixel.
 */

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int r = image.length, c = image[0].length;
        int[][] newimage = new int[r][c];
        int[][] visited = new int[r][c];
        newimage[sr][sc] = newColor;
        dfs(image, newimage, sr, sc, newColor, visited);
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                if(visited[i][j] != 1)
                    newimage[i][j] = image[i][j];
            }
        }
        return newimage;
    }
    
    int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    public void dfs(int[][] image, int[][] newimage, int sr, int sc, int newColor, int[][] visited){
        visited[sr][sc] = 1;
        for(int[] dir : dirs){
            int row = sr + dir[0];
            int col = sc + dir[1];
            if(row >= 0 && row < image.length && col >= 0 && col < image[0].length && visited[row][col] != 1){
                if(image[row][col] == image[sr][sc]){
                    newimage[row][col] = newColor;
                    dfs(image, newimage, row, col, newColor, visited);
                }
            }
        } 
    }
}

/*
    2 2 2   1 1 1 
    2 2 0   1 1 0
    2 0 1   1 0 1

*/