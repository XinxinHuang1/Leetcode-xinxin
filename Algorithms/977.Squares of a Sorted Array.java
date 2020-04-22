/**
 * 
Given an array of integers A sorted in non-decreasing order, return an array of the squares of each number, also in sorted non-decreasing order.

 

Example 1:

Input: [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Example 2:

Input: [-7,-3,2,3,11]
Output: [4,9,9,49,121]

 */


 //Time O(N)
class Solution {
    public int[] sortedSquares(int[] A) {
        int[] res = new int[A.length];
        int l = 0, r = A.length - 1;
        for(int i = A.length - 1; i >= 0; i--){
            int m = A[l] * A[l];
            int n = A[r] * A[r];
            if(m >= n){
                res[i] = m;
                l++;
            }
            else{
                res[i] = n;
                r--;
            }
        }
        return res;
    }
}