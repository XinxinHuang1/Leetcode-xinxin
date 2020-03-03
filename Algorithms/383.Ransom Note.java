/*Easy
Given an arbitrary ransom note string and another string containing letters from all the magazines, write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.

Each letter in the magazine string can only be used once in your ransom note.

Note:
You may assume that both strings contain only lowercase letters.

canConstruct("a", "b") -> false
canConstruct("aa", "ab") -> false
canConstruct("aa", "aab") -> true
 */

class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c : magazine.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for(char r : ransomNote.toCharArray()){
            if(map.get(r) == null || map.get(r) == 0)
                return false;
            map.put(r, map.get(r) - 1);
        }
        return true;
    }
}

//faster
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] map = new int[26];
        for(int i = 0; i < magazine.length(); i++){
            map[magazine.charAt(i) - 'a']++;
        }
        for(int i = 0; i < ransomNote.length(); i++){
            map[ransomNote.charAt(i) - 'a']--;
        }
        for(int i : map){
            if(i < 0)
                return false;
        }
        return true;
    }
}

//similar to above, more concise, faster
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] map = new int[26];
        for(int i = 0; i < magazine.length(); i++){
            map[magazine.charAt(i) - 'a']++;
        }
        for(int i = 0; i < ransomNote.length(); i++){
            if(--map[ransomNote.charAt(i) - 'a'] < 0)
                return false;
        }
        return true;
    }
}