/**
 Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

Note: For the purpose of this problem, we define empty string as valid palindrome.

Example 1:

Input: "A man, a plan, a canal: Panama"
Output: true
 */

class Solution {
    public boolean isPalindrome(String s) {
        if(s == null || s.length() == 0)
            return true;
        
        int head = 0, tail = s.length() - 1;
        while(head <= tail){
            char chead = s.charAt(head);
            char ctail = s.charAt(tail);
            if(!Character.isLetterOrDigit(chead))
                head++;
            else if(!Character.isLetterOrDigit(ctail)){
                tail--;
            }
            else if(Character.toLowerCase(chead) != Character.toLowerCase(ctail))
                return false;
            else{
                head++;
                tail--;
            }
        }
        return true;
    }
}