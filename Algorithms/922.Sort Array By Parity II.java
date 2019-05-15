//source: https://leetcode.com/problems/sort-array-by-parity-ii/
//Easy
//Array
//Date: May 15 2019

/*
Given an array A of non-negative integers, half of the integers in A are odd, and half of the integers are even.
Sort the array so that whenever A[i] is odd, i is odd; and whenever A[i] is even, i is even.
You may return any answer array that satisfies this condition.

Example 1:

Input: [4,2,5,7]
Output: [4,5,2,7]
Explanation: [4,7,2,5], [2,5,4,7], [2,7,4,5] would also have been accepted.

Note:

2 <= A.length <= 20000
A.length % 2 == 0
0 <= A[i] <= 1000
*/

//runtime 3ms, beats 73%
class Solution {
    public int[] sortArrayByParityII(int[] A) {
        int n = A.length;
        int[] B = new int[n];
        
        int j = 0;
        for(int i = 0; i < n; i++){
            if(A[i] % 2 == 0){
                B[j] = A[i];
                j+=2;
            }
        }
        j = 1;
        for(int i = 0; i < n; i++){
            if(A[i]%2 != 0){
                B[j] = A[i];
                j+=2;
            }
        }
        return B;
    }
}

//solution 2 time complexity O(N), space complexity O(N)
class Solution {
    public int[] sortArrayByParityII(int[] A) {
        int n = A.length;
        int[] B = new int[n];
        
        int i = 0;
        for(int a : A)
            if(a % 2 == 0){
                B[i] = a;
                i+=2;
            }
        i = 1;
        for(int a : A)
            if(a % 2 == 1){
                B[i] = a;
                i+=2;
            }
        return B;
    }
}

// solution 3, 2ms, beats 99%. Time Complexity: O(N), space complexity O(1)
class Solution {
    public int[] sortArrayByParityII(int[] A) {
        int n = A.length;
        int j = 1;
        for(int i = 0; i < n; i+=2){
            if(A[i] % 2 == 1){
                while(A[j] % 2 == 1)
                    j+=2;
                int tmp = A[i];
                A[i] = A[j];
                A[j] = tmp;
            }
        }
         return A;
    }
}





