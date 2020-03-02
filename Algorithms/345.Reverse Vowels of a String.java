/*Easy

Write a function that takes a string as input and reverse only the vowels of a string.

Example 1:

Input: "hello"
Output: "holle"
Example 2:

Input: "leetcode"
Output: "leotcede"
Note:
The vowels does not include the letter "y".
 */

class Solution {
    public String reverseVowels(String s) {
        Stack<Character> stack = new Stack<>();
        HashSet<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        for(char c : s.toCharArray()){
            if(set.contains(c)){
                stack.add(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char ch : s.toCharArray()){
            if(set.contains(ch))
                sb.append(stack.pop());
            else
                sb.append(ch);
        }
        return sb.toString();
    }
}