/**Easy
 Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

Example 1:
Input: "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
Note: In the string, each word is separated by single space and there will not be any extra space in the string.
 */

 //solution 1
 //Time O(N) Space O(N)
class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        for(String word : s.split(" ")){
            String reversedWord = reverse(word);
            sb.append(reversedWord).append(" ");
        }
        return sb.toString().substring(0, sb.length() - 1);
    }
    
    public String reverse(String word){
        int start = 0; 
        int end = word.length() - 1;
        char[] ch = word.toCharArray();
        while(start < end){
            char tmp = ch[start];
            ch[start++] = ch[end];
            ch[end--] = tmp;
        }
        return new String(ch);
    }
}

//solution2 StringBuilder and StringBuffer
class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        for(String word : s.split(" ")){
            sb.append(new StringBuffer(word).reverse().toString()).append(" ");
        }
        return sb.toString().substring(0, sb.length() - 1);
    }
}