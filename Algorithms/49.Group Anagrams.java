/*Medium
Given an array of strings, group anagrams together.

Example:

Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:

All inputs will be in lowercase.
The order of your output does not matter
 */

//Time O(NKlogK), N: length of strs, K, maximum length of a string in strs
//Space O(NK)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0)
            return new ArrayList<>();
        
        HashMap<String, List<String>> map = new HashMap<>();
        for(String s : strs){
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String key = String.valueOf(c);
            if(!map.containsKey(key))
                map.put(key, new ArrayList<>());
            map.get(key).add(s);
        }
        return new ArrayList<>(map.values());
    }
}