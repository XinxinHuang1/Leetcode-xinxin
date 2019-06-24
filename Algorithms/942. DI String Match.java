//source:  https://leetcode.com/problems/di-string-match/
// @Xinxin Huang
// 2019-6.24

/******************************************************

Given a string S that only contains "I" (increase) or "D" (decrease), let N = S.length.

Return any permutation A of [0, 1, ..., N] such that for all i = 0, ..., N-1:

If S[i] == "I", then A[i] < A[i+1]
If S[i] == "D", then A[i] > A[i+1]
 

Example 1:

Input: "IDID"
Output: [0,4,1,3,2]
Example 2:

Input: "III"
Output: [0,1,2,3]
Example 3:

Input: "DDI"
Output: [3,2,0,1]
 

Note:

1 <= S.length <= 10000
S only contains characters "I" or "D".
*******************************************************/

//runtime 2ms, beats 95%
class Solution {
    public int[] diStringMatch(String S) {
        int N = S.length();
        int[] result = new int[N+1];
        int lo = 0, hi = N;
        for(int i = 0; i < N; i++){
            if(S.charAt(i) == 'I'){
                result[i] = lo++;
            }
            else
                result[i] = hi--;
        }
        result[N] = lo;
        return result;
    }
}

