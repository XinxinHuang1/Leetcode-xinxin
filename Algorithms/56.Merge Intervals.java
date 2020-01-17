/**
 * 56. Merge Intervals

Given a collection of intervals, merge all overlapping intervals.

Example 1:

Input: [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * 
 */

class Solution {
    
    public int[][] merge(int[][] intervals) {
       
        //edge case 
        if(intervals.length <= 1)
            return intervals;
        
        //sort input by comparing left integer of each int[]
        // Lambda comparator (java 8)
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));// O(NlogN) time
        
        List<int[]> ans = new ArrayList<int[]>();
        int[] left = intervals[0];
        
        ans.add(left);
        
        for(int[] right : intervals){
            if(right[0] <= left[1])
                left[1] = Math.max(left[1], right[1]);
            else{
                left = right;
                ans.add(left);
            }
        }
        return ans.toArray(new int[ans.size()][2]);
    }
}