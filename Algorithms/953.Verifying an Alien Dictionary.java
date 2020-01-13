
//time: O(c) c: totel content of words 
//space：O(1)
class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] index = new int[26];
        for(int i = 0; i < order.length(); i++){
            index[order.charAt(i) - 'a'] = i;
        }
        for(int i = 0; i < words.length - 1; i++){
            int len = Math.min(words[i].length(), words[i+1].length());
            for(int j = 0; j < len; j++){
                if(words[i].charAt(j) != words[i+1].charAt(j)){
                    if(index[words[i].charAt(j) - 'a'] > index[words[i+1].charAt(j) - 'a'])
                        return false;
                    else
                        len = -1;
                }
            }
            if(len != -1 && words[i].length() > words[i+1].length())
                return false;
        }
     return true;
    }
}