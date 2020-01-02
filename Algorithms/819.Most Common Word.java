//819.Most Common Word - Easy
//Solution 1: 
class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        String[] s = paragraph.toLowerCase().split("[ .,;!?']+");//+ represents one or more times
                
        HashMap<String, Integer> map = new HashMap<>();
        
        for(String word : s){
            map.put(word, map.getOrDefault(word,0)+1);
        }
        for(String word : banned){
            if(map.containsKey(word))
                map.remove(word);
        }
        
        String ans = null;
        for(String word: map.keySet()){
            if(ans == null || map.get(word) > map.get(ans)){
                ans = word;
            }
        }
        return ans;
    }
}
//Solution 2 (faster)
class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> banset = new HashSet<>();

        for(String s : banned)
            banset.add(s);
        
        Map<String, Integer> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        
        int ansfreq = 0;
        String ans = null;
        for(char c : paragraph.toCharArray()){
            if(Character.isLetter(c)){
                sb.append(Character.toLowerCase(c));
            }
            else if(sb.length() > 0){
                String finalword = sb.toString();
                if(!banset.contains(finalword)){
                    map.put(finalword, map.getOrDefault(finalword, 0) + 1);
                    if(map.get(finalword) > ansfreq){
                        ans = finalword;
                        ansfreq = map.get(finalword);
                    }
                }
                sb = new StringBuilder();
            }
        }
        return ans;
    }
}//Time: O(P+B) P- size of paragraph, B- size of banned      Space: O(P+B)