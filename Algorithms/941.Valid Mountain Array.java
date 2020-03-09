/*
Given an array A of integers, return true if and only if it is a valid mountain array.

Recall that A is a mountain array if and only if:

A.length >= 3
There exists some i with 0 < i < A.length - 1 such that:
A[0] < A[1] < ... A[i-1] < A[i]

Example 1:

Input: [2,1]
Output: false
Example 2:

Input: [3,5,5]
Output: false
Example 3:

Input: [0,3,2,1]
Output: true
*/


//Time O(N) Space O(1)
class Solution {
    public boolean validMountainArray(int[] A) {
        int n = A.length;
        if(n < 3) return false;
        
        int i = 0;
        while(i < n - 1 && A[i] < A[i+1])
            i++;
        if(i == 0 || i == n - 1)
            return false;
        while(i < n - 1 && A[i] > A[i+1])
            i++;
        return i == n - 1;
    }
}