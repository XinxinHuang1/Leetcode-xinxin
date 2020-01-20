/**
 Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
The order of output does not matter.

Example 1:
Input:
s: "cbaebabacd" p: "abc"
Output:
[0, 6]
 */
//Solution: HashMap
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<Integer>();
        if(s == null || s.length() == 0 || s.length() < p.length())
            return res;
        
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(char c : p.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        //the need of chars for each anagram
        int match = 0;
        
        for(int i = 0; i < s.length(); i++){
            //find the valid anagram, set if match all chars, record the start index
            // eg. cba recorded
            char c = s.charAt(i);
            if(map.containsKey(c)){
                map.put(c, map.get(c) - 1);
                if(map.get(c) == 0)
                    match++;
            }
            // iterate back the recorded index
            // minus the match count so that can restart to count matches
            // eg. go back to cba and minus the match count
            if(i >= p.length()){
                char c1 = s.charAt(i - p.length());
                if(map.containsKey(c1)){
                    map.put(c1, map.get(c1) + 1);
                    if(map.get(c1) == 1)
                        match--;
                }
            }
            // record each starting index
            if(match == map.size()){
                res.add(i - p.length() + 1);
            }
        }
        return res;
    }
}