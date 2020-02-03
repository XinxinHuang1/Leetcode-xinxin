/* 
The printer can only print a sequence of the same character each time.
At each turn, the printer can print new characters starting from and ending at any places, and will cover the original existing characters.
Given a string consists of lower English letters only, your job is to count the minimum number of turns the printer needed in order to print it.

Example 1:
Input: "aaabbb"
Output: 2
Explanation: Print "aaa" first and then print "bbb".
*/


//Time O(N^3) Space O(N^2)- space of int[][] dp
class Solution {
    public int strangePrinter(String s) {
        int n = s.length();
        if(n == 0) return 0;
        //dp: start index, length, value = print times
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++){
            dp[i][i] = 1;
        }
        for(int j = 1; j < n; j++){
            for(int i = 0; i + j < n; i++){
                dp[i][i+j] = j + 1;
                for(int k = i; k < i + j; k++){
                    int sum = dp[i][k] + dp[k+1][i+j];
                    if(s.charAt(k) == s.charAt(i+j))
                        sum--;
                    dp[i][i+j] = Math.min(dp[i][i+j], sum);
                }
            }
        }
        return dp[0][n-1];
    }
}