/*

Given a string s formed by digits ('0' - '9') and '#' . We want to map s to English lowercase characters as follows:

Characters ('a' to 'i') are represented by ('1' to '9') respectively.
Characters ('j' to 'z') are represented by ('10#' to '26#') respectively. 
Return the string formed after mapping.

It's guaranteed that a unique mapping will always exist.

 

Example 1:

Input: s = "10#11#12"
Output: "jkab"
Explanation: "j" -> "10#" , "k" -> "11#" , "a" -> "1" , "b" -> "2".
Example 2:

Input: s = "1326#"
Output: "acz"
Example 3:

Input: s = "25#"
Output: "y"
Example 4:

Input: s = "12345678910#11#12#13#14#15#16#17#18#19#20#21#22#23#24#25#26#"
Output: "abcdefghijklmnopqrstuvwxyz"
 1 */

class Solution {
    public String freqAlphabets(String s) {
        int index = s.length() - 1;
        StringBuilder sb = new StringBuilder();
        while(index >= 0){
            if(s.charAt(index) == '#'){
                String cur = s.substring(index - 2, index + 1);
                sb.append(convert(cur));
                index -= 3;
            }
            else{
                String cur = s.substring(index, index + 1);
                sb.append(convert(cur));
                index --;
            }
        }
        return sb.reverse().toString();
    }
    public String convert(String a){
        String res;
        int input;
        if(a.length() == 1){
            input = Integer.valueOf(a);
        }
        else{
            input = Integer.valueOf(a.substring(0,2));
        }
        char c = (char)('a' + (input - 1));
        return Character.toString(c);
    }
}
