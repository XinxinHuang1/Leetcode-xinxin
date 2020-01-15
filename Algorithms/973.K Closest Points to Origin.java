/*
We have a list of points on the plane.  Find the K closest points to the origin (0, 0).

(Here, the distance between two points on a plane is the Euclidean distance.)

Example 1:

Input: points = [[1,3],[-2,2]], K = 1
Output: [[-2,2]]
*/

// time O(N log N)     space O(N)
class Solution {
    public int[][] kClosest(int[][] points, int K) {
        int len = points.length;
        int[] dist = new int[len];
        for(int i = 0; i < len; i++){
            dist[i] = calcDist(points[i]);
        }
        
        Arrays.sort(dist);
        
        int[][] ans = new int[K][2];
        int distK = dist[K-1]; // Kth smallest dist 
        int t = 0;
        for(int i = 0; i < len; i++){
            if(calcDist(points[i]) <= distK)
                ans[t++] = points[i];
        }
        return ans;
    }
    private int calcDist(int[] point){
        return point[0] * point[0] + point[1] * point[1];
    }
}