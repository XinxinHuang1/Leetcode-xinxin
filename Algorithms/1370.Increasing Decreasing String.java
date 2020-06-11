/*
Given a string s. You should re-order the string using the following algorithm:

Pick the smallest character from s and append it to the result.
Pick the smallest character from s which is greater than the last appended character to the result and append it.
Repeat step 2 until you cannot pick more characters.
Pick the largest character from s and append it to the result.
Pick the largest character from s which is smaller than the last appended character to the result and append it.
Repeat step 5 until you cannot pick more characters.
Repeat the steps from 1 to 6 until you pick all characters from s.
In each step, If the smallest or the largest character appears more than once you can choose any occurrence and append it to the result.

Return the result string after sorting s with this algorithm.

 

Example 1:

Input: s = "aaaabbbbcccc"
Output: "abccbaabccba"
Explanation: After steps 1, 2 and 3 of the first iteration, result = "abc"
After steps 4, 5 and 6 of the first iteration, result = "abccba"
First iteration is done. Now s = "aabbcc" and we go back to step 1
After steps 1, 2 and 3 of the second iteration, result = "abccbaabc"
After steps 4, 5 and 6 of the second iteration, result = "abccbaabccba" */

class Solution {
    public String sortString(String s) {
        int[] map = new int[26];
        for(char c : s.toCharArray()){
            map[c - 'a']++;
        }
        int count = 0;
        StringBuilder sb = new StringBuilder();
        while(count < s.length()){
            for(int i = 0; i < 26; i++){
                if(map[i] > 0){
                    sb.append((char)(i + 'a'));
                    map[i]--;
                    count++;
                }
            }
            for(int i = 25; i >= 0; i--){
                if(map[i] > 0){
                    sb.append((char)(i + 'a'));
                    map[i]--;
                    count++;
                }
            }
        }
        return sb.toString();
    }
}

/*
aaaabbbbcccc
a b c c b a a b c c b a

l e e t c o d e 
c 1
d 1
e 3
l 1
o 1 
t 1

c d e l o t e e 
*/
