/*Easy
Given a string S, return the "reversed" string where all characters that are not a letter stay in the same place, and all letters reverse their positions.
Example 1:

Input: "ab-cd"
Output: "dc-ba"
Example 2:

Input: "a-bC-dEf-ghIj"
Output: "j-Ih-gfE-dCba"
Example 3:

Input: "Test1ng-Leet=code-Q!"
Output: "Qedo1ct-eeLg=ntse-T!"
 */


 //two pointer
 class Solution {
    public String reverseOnlyLetters(String S) {
        int i = 0, j = S.length() - 1;
        char[] ch = S.toCharArray();
        while(i < j){
            while(i < j && !Character.isLetter(ch[i]))
                i++;
            while(i < j && !Character.isLetter(ch[j]))
                j--;
            char tmp = ch[i];
            ch[i] = ch[j];
            ch[j] = tmp;
            i++;
            j--;
        }
        return new String(ch);
    }
}

 //time O(N) space O(N)
class Solution {
    public String reverseOnlyLetters(String S) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < S.length(); i++){
            char c = S.charAt(i);
            if(Character.isLetter(c))
                stack.push(c);
        }
        StringBuilder sb = new StringBuilder();
        for(char c : S.toCharArray()){
            if(Character.isLetter(c)){
                sb.append(stack.pop());
            }
            else 
                sb.append(c);
        }
        return sb.toString();
    }
}


class Solution {
    public String reverseOnlyLetters(String S) {
        ArrayList<Character> chars = new ArrayList<>();
        for(int i = S.length()-1; i >= 0; i--){
            if(Character.isLetter(S.charAt(i)))
                chars.add(S.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        if(chars.size() == 0){
            for(char c : S.toCharArray()){
                sb.append(c);
            }
        }
        while(i < chars.size()){
            for(char c : S.toCharArray()){
                if(Character.isLetter(c)){
                    sb.append(chars.get(i));
                    i++;
                }
                else
                    sb.append(c);
            }
        }
        return sb.toString();
    }
}
