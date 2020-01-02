//991. Broken Calculator 

/*
On a broken calculator that has a number showing on its display, 
we can perform two operations:

Double: Multiply the number on the display by 2, or;
Decrement: Subtract 1 from the number on the display.

Initially, the calculator is displaying the number X.
Return the minimum number of operations needed to display the number Y.

Example 1:

Input: X = 2, Y = 3
Output: 2
Explanation: Use double operation and then decrement operation {2 -> 4 -> 3}.

*/

//Solution 1: Work Backwards
class Solution {
    public int brokenCalc(int X, int Y) {
        int ans = 0;
        while(Y > X){
            ans++;
            if(Y % 2 == 1)
                Y++;
            else 
                Y /= 2;
        }
        return ans + X - Y;
    }
}
//Time:O(Log(Y)), Space: O(1)

//Solution 2
class Solution {
    public int brokenCalc(int X, int Y) {
        if(X == Y)
            return 0;
        else 
            return (X > Y ? X - Y : 1 + Y % 2 + brokenCalc(X, (Y+1)/2));
    }
}