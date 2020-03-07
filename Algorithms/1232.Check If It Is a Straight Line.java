/*
You are given an array coordinates, coordinates[i] = [x, y], where [x, y] represents the coordinate of a point. Check if these points make a straight line in the XY plane.

Example 1:

Input: coordinates = [[1,2],[2,3],[3,4],[4,5],[5,6],[6,7]]
Output: true */

//time space beats 100%
class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        int n = coordinates.length;
        if(n < 2)
            return false;
        double k = calcK(coordinates[0], coordinates[1]);
        
        for(int i = 0; i < n - 1; i++){
            int[] cur = coordinates[i];
            int[] next = coordinates[i+1];
            double curK = calcK(coordinates[i], coordinates[i+1]);
            if(curK != k)
                return false;
        }
        return true;
    }
    public double calcK(int[] a, int[] b){
        double k = (double) (b[1] - a[1])/(b[0] - a[0]);
        return k;
    }
}
