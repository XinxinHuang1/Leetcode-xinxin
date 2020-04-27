/*
Given an array A of integers and integer K
return the maximum S such that there exists:
i < j
A[i] + A[j] = S
S < K
if no i j exists satisfying this equation, return -1
*/


class Solution{
    public int twoSumLessThanK(int[] A, int K){
        Arrays.sort(A);
        int l = 0, r = A.length - 1;
        int max = 0;
        while(l <= r){
            int cur = A[l] + A[r];
            if(cur < K){
                max = Math.max(max, cur);
                l++;
            }
            else
                r--;
        }
        return max;
    }
}