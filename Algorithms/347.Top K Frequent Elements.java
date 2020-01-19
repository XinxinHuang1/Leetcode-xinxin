/**
 Given a non-empty array of integers, return the k most frequent elements.

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]
 */

// Solution1: Priority Queue 
//Time O(NlogK) map is N, priorityQueue is NlogK
//Space O(N) to store hashmap
class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        //key value, value  freq 
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int n : nums){
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        
        // save values to priority queue, order by frequency
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>((n1, n2) -> map.get(n1) - map.get(n2));
        for(int n : map.keySet()){
            heap.offer(n);
            // keep updating heap, only keeping kth frequent numbers
            if(heap.size() > k)
                heap.poll();
        }
        // save heap to arraylist
        List<Integer> res = new ArrayList<Integer>();
        while(!heap.isEmpty()){
            res.add(heap.poll());
            //Collections.reverse(res); -- if need original order 
        }
        return res;
    }
}