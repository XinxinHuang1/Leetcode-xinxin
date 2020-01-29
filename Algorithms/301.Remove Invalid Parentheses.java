/**
 Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.

Note: The input string may contain letters other than the parentheses ( and ).

Example 1:

Input: "()())()"
Output: ["()()()", "(())()"]
Example 2:

Input: "(a)())()"
Output: ["(a)()()", "(a())()"]
 */


class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<String>();
        helper(s, res, 0, 0, '(', ')');
        return res;
    }
    
    public void helper(String s, List<String> res, int i_start, int j_start, char open, char close){
        int countOpen = 0, countClose = 0;
        for(int i = i_start; i < s.length(); i++){
            if(s.charAt(i) == open)
                countOpen++;
            if(s.charAt(i) == close)
                countClose++;
            if(countClose > countOpen){
                for(int j = j_start; j <= i; j++){
                    if(s.charAt(j) == close && (j == j_start || s.charAt(j-1) != close)){
                        helper(s.substring(0,j) + s.substring(j+1, s.length()), res, i, j, open, close);
                    }
                }
                return;
            }
        }
        
        // consider when ( is more than ), reverse string
        String reversed = new StringBuilder(s).reverse().toString();
        if(open == '(')
            helper(reversed, res, 0, 0, ')', '(');
        else
            res.add(reversed);
    }
}