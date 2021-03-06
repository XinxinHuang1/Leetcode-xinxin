//source: https://leetcode.com/problems/fibonacci-number/
//Easy
//Array
//Date: May 14 2019

/*
The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,
F(0) = 0,   F(1) = 1
F(N) = F(N - 1) + F(N - 2), for N > 1.
Given N, calculate F(N).

Example 1:
Input: 2
Output: 1
Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.

Example 2:
Input: 3
Output: 2
Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.

Example 3:
Input: 4
Output: 3
Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.

Note:
0 ≤ N ≤ 30.
*/

//runtime 0ms, beats 100%
class Solution {
    public int fib(int N) {
        int[] a = new int[N+1];
        if(N >= 2){
            a[0] = 0;
            a[1] = 1;
            for(int i = 2; i <= N; i++){
                a[i] = a[i-1]+a[i-2];
            }
            return a[N];
        }
        else if(N == 0)
            return 0;
        else
            return 1;
    }
}




