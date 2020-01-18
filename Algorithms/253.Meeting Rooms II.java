/*
Given an array of meeting time intervals consisting of start and end times,
find the minimum number of meeting rooms required.

Example 
Input: 
[[0,30], [5, 10], [15, 20]]
Output: 
2
*/
import java.util.*;

class MeetingRooms{
    static int minMeetingRooms(int[][] intervals){
        if(intervals.length == 0)
            return 0;
        
        int n = intervals.length;
        // use Integer arrays to save start times
        Integer[] start = new Integer[n];
        Integer[] end = new Integer[n];
        // populate these two arrays
        for(int i = 0; i < n; i++){
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        //sort the two arrays
        Arrays.sort(start, new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                return a - b;
            }        
        });

        Arrays.sort(end, new Comparator<Integer>(){
            public int compare(Integer a, Integer b){
                return a - b;
            }
        });

        //count rooms
        int left = 0, right = 0, rooms = 0;
        while(left < n){
            //if a room is available for another meeting, rooms - 1
            if(start[left] >= end[right]){
                rooms -= 1;
                right += 1;
            }
            //if need a new room, rooms +1
            rooms += 1;
            left += 1;
        }
        return rooms;
    }

    public static void main(String[] args){
        int[][] intervals = {{0,30}, {5, 10}, {15, 20}};
        System.out.println(minMeetingRooms(intervals));
    }
}