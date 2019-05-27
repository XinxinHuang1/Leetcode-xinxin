//source: https://leetcode.com/problems/height-checker/
//Easy
//Array
//Date: May 27 2019

/*******************************************************************************
Students are asked to stand in non-decreasing order of heights for an annual photo.

Return the minimum number of students not standing in the right positions.  (This is the number of students that must move in order for all students to be standing in non-decreasing order of height.)

Example 1:
Input: [1,1,4,2,1,3]
Output: 3
Explanation: 
Students with heights 4, 3 and the last 1 are not standing in the right positions.
 
Note:
1 <= heights.length <= 100
1 <= heights[i] <= 100

**********************************************************************************/


//runtime 1ms, beats 99%
class Solution {
    public int heightChecker(int[] heights) {
        int[] copy = heights.clone();
        Arrays.sort(copy);
        
        int ans = 0, n = heights.length;
        for(int i = 0; i < n; i++){
            if(copy[i] != heights[i])
                ans++;
        }
        return ans;
    }
}



