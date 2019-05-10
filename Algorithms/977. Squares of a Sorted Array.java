//source: https://leetcode.com/problems/squares-of-a-sorted-array/
//Easy
//Date: May 7 2019

/*
Given an array of integers A sorted in non-decreasing order, return an array of the squares of each number, also in sorted non-decreasing order.
Example 1:
Input: [-4,-1,0,3,10]
Output: [0,1,9,16,100]

Example 2:
Input: [-7,-3,2,3,11]
Output: [4,9,9,49,121]
*/

//solution 1 126 ms beats 6.65% 
class Solution {
    public int[] sortedSquares(int[] A) {
        int n = A.length;
        int[] B = new int[n];
        for(int i = 0; i < n; i++){
            B[i] = A[i] * A[i];
        }
        //insertion sort for array B
        for(int i = 1; i < n; i++){
            for(int j = i; j > 0 && B[j] < B[j-1]; j--){
                swap(B,j,j-1);
            }
        }
        return B;
    }
    public void swap(int[] array, int i,int j){
            int tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;
        }
}

// solution 2 2ms beats 92%
class Solution {
    public int[] sortedSquares(int[] A) {
        int n = A.length;
        int[] B = new int[n];
        for(int i = 0; i < n; i++){
            B[i] = A[i] * A[i];
        }
        //import java.util.Arrays;
        Arrays.sort(B);
        return B;
    }
}

