/**
 
Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

Example 1:

Input: [1,1,3,3,5,6] and k = 3
Output: 3


 */

 //Solution 1: priority queue/heap   Time O(NlogK)  - add num to queue  Space: O(K)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        
        // q: 1, 1,3,3,5, 6 k = 4
        PriorityQueue<Integer> q = new PriorityQueue<Integer>((n1, n2) -> n1 - n2);
        //Or JUST   PriorityQueue<Integer> q = new PriorityQueue<Integer>();
        
        // keep adding element to queue, remain only the last K elements
        //1 , 1 ,3, 3
        //1, 3, 3, 5
        // 3, 3, 5, 6 return 3;
        for(int n : nums){
            q.add(n);
            if(q.size() > k)
                q.poll();
        }
        return q.poll();
    }
}

//Solution 2: 