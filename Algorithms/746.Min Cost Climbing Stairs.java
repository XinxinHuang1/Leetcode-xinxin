/*Easy
On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).

Once you pay the cost, you can either climb one or two steps. You need to find minimum cost to reach the top of the floor, and you can either start from the step with index 0, or the step with index 1.

Example 1:
Input: cost = [10, 15, 20]
Output: 15
Explanation: Cheapest is start on cost[1], pay that cost and go to the top.
Example 2:
Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
Output: 6
Explanation: Cheapest is start on cost[0], and only step on 1s, skipping cost[3].
 */

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        if(n == 0)
            return 0;
        if(n < 2)
            return cost[0];
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = Math.min(dp[0], cost[0]); // 1, 0, 0, 0
        for(int i = 2; i <= n; i++){
            dp[i] = Math.min(dp[i-1] + cost[i-1], cost[i-2] + dp[i-2]);
        }
        return dp[n];
    }
}

/*
1  100  1  1  1  1   100  1  1  100  1
0   1   1  2  2  3    3   4   5      6

dp[3]-> dp[i-1] + cost[i-1] 101, dp[i-2] + cost[i-2] = 1
*/