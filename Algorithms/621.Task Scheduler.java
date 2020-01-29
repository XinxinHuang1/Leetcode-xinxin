/**
 Given a char array representing tasks CPU need to do. It contains capital letters A to Z where different letters represent different tasks. Tasks could be done without original order. Each task could be done in one interval. For each interval, CPU could finish one task or just be idle.

However, there is a non-negative cooling interval n that means between two same tasks, there must be at least n intervals that CPU are doing different tasks or just be idle.

You need to return the least number of intervals the CPU will take to finish all the given tasks.

Example:

Input: tasks = ["A","A","A","B","B","B"], n = 2
Output: 8
Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
 */


class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : tasks){
            map.put(c, map.getOrDefault(c,0) + 1);
        }
        //use priority queue to sort frequency
        PriorityQueue<Integer> queue = new PriorityQueue<>((a,b) -> b - a);
        queue.addAll(map.values());
        
        //arrage tasks 
        int cycle = 0;
        while(!queue.isEmpty()){
            List<Integer> temp = new ArrayList<Integer>();//store each valid groups
            for(int i = 0; i <= n; i++){
                if(!queue.isEmpty()){
                    temp.add(queue.remove());
                }
            }
            // 3,3 -> 2 2 -> 1 1 
            for(int i : temp){
                if(--i > 0){
                    queue.add(i);
                }
            }
            cycle += queue.isEmpty() ? temp.size() : n + 1;
        }
        return cycle;
    }
}