/**
 Given a string S, check if the letters can be rearranged so that two characters that are adjacent to each other are not the same.

If possible, output any possible result.  If not possible, return the empty string.

Example 1:

Input: S = "aab"
Output: "aba"
 */

class Solution {
    public String reorganizeString(String S) {
        // key: char  value: frequency
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(char c : S.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        
        PriorityQueue<Map.Entry<Character,Integer>> q = new PriorityQueue<>((a,b) -> (b.getValue() - a.getValue()));
        q.addAll(map.entrySet());
        
        StringBuilder sb = new StringBuilder();
        Map.Entry<Character,Integer> prev = null;
        
        while(!q.isEmpty()){
            //cur : most frequent char
            Map.Entry<Character, Integer> cur = q.poll();

            sb.append(cur.getKey());
            
            cur.setValue(cur.getValue() - 1);
            
            if(prev != null)
                q.offer(prev);
                
            if(cur.getValue() > 0)
                prev = cur;
            else 
                prev = null;
        }
        return sb.length() == S.length() ? sb.toString() : "";
    }
}