/*
Given an array A of strings made only from lowercase letters, return a list of all characters that show up in all strings within the list (including duplicates).  For example, if a character occurs 3 times in all strings but not 4 times, you need to include that character three times in the final answer.

You may return the answer in any order.

 

Example 1:

Input: ["bella","label","roller"]
Output: ["e","l","l"]
Example 2:

Input: ["cool","lock","cook"]
Output: ["c","o"]
 
*/

class Solution {
    public List<String> commonChars(String[] A) {
        List<String> res = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : A[0].toCharArray()){
            map.put(c, map.getOrDefault(c,0) + 1);
        }
        for(int i = 1; i < A.length; i++){
            HashMap<Character, Integer> newMap = new HashMap<>();
            String word = A[i];
            for(char c : word.toCharArray()){
                newMap.put(c, newMap.getOrDefault(c, 0) + 1);
            }
            for(char c : map.keySet()){
                if(newMap.get(c) == null)
                    map.put(c, 0);
                else{
                    map.put(c, Math.min(map.get(c), newMap.get(c)));
                }
            }
        }
        for(char c: map.keySet()){
            while(map.get(c) > 0){
                res.add(Character.toString(c));
                map.put(c, map.get(c) -1);
            }
        }
        return res;
    }
}

//solution 2
class Solution {
    public List<String> commonChars(String[] A) {
        int[] map = new int[26];
        for(char c : A[0].toCharArray()){
            map[c - 'a']++;
        }
        for(int i = 1; i < A.length; i++){
            int[] newMap = new int[26];
            for(char c : A[i].toCharArray()){
                newMap[c - 'a']++;
            }
            for(int j = 0; j < 26; j++){
                map[j] = Math.min(map[j], newMap[j]);
            }
        }
        List<String> res = new ArrayList<>();
        for(int i = 0; i < 26; i++){//index
            for(int j = 0; j < map[i]; j++){ //index occurence
                res.add((char)(i + 'a') + "");
            }
            /* OR
            while(map[i] > 0){
                res.add((char)(i + 'a') + "");
                map[i]--;
            }
             */
        }
        return res;
    }
}
/*
      b   d d
    0 1 2 3 4 5 6 ...26
map 0 1 0 2  
*/

