/**
 In a row of seats, 1 represents a person sitting in that seat, and 0 represents that the seat is empty. 

There is at least one empty seat, and at least one person sitting.

Alex wants to sit in the seat such that the distance between him and the closest person to him is maximized. 

Return that maximum distance to closest person.

Example 1:

Input: [1,0,0,0,1,0,1]
Output: 2
Explanation: 
If Alex sits in the second open seat (seats[2]), then the closest person has distance 2.
If Alex sits in any other open seat, the closest person has distance 1.
Thus, the maximum distance to the closest person is 2.
Example 2:

Input: [1,0,0,0]
Output: 3
Explanation: 
If Alex sits in the last seat, the closest person is 3 seats away.
This is the maximum distance possible, so the answer is 3.
 */

class Solution {
    public int maxDistToClosest(int[] seats) {
        int n = seats.length;
        int[] leftdp = new int[n];
        int leftindex = 0;
        for(int i = 0; i < n; i++){
            if(seats[i] == 1){
                leftindex = i;
                leftdp[i] = 0;
            }
            leftdp[i] = i - leftindex;
        }
        int[] rightdp = new int[n];
        int rightindex = n-1;
        for(int i = n-1; i >= 0; i--){
            if(seats[i] == 1){
                rightindex = i;
                rightdp[i] = 0;
            }
            rightdp[i] = rightindex - i;
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            int cur;
            if(leftdp[i] == 0 || rightdp[i] == 0)
                cur = leftdp[i] == 0 ? rightdp[i] : leftdp[i];
            else
                cur = Math.min(leftdp[i], rightdp[i]);
            max = Math.max(cur, max);
        }
        return max;
    }
}

/*
1   0 0 0 
0   1 2 3
0   2 1 0

1 0 0 0 1 0 1

0 1 2 3 0 1 0

0 3 2 1 0 1 0

0 1 2 1 0 1 0
*/