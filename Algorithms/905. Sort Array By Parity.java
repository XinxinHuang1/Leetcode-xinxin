//source: https://leetcode.com/problems/sort-array-by-parity/
//Easy
//Array
//Date: May 10 2019

/*
Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.
You may return any answer array that satisfies this condition.
Example 1:
Input: [3,1,2,4]
Output: [2,4,3,1]
The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
Note:
1 <= A.length <= 5000
0 <= A[i] <= 5000
*/

//runtime 1ms, beats 100%
class Solution {
    public int[] sortArrayByParity(int[] A) {
        int n = A.length;
        int a = 0, b = 0;
        for(int i = 0; i < n; i++){
            if(A[i] % 2 != 0){
                a = i;
                b = i + 1;
                break;
            }
        }
        while(b < n){
            if(A[b] % 2 == 0){
                swap(A,a++,b);
            }
            b++;
        }
        return A;
    }
    private void swap(int[] A, int i, int j){
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }
}






