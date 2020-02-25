/*Easy
Given words first and second, consider occurrences in some text of the form "first second third", where second comes immediately after first, and third comes immediately after second.

For each such occurrence, add "third" to the answer, and return the answer.

Example 1:

Input: text = "alice is a good girl she is a good student", first = "a", second = "good"
Output: ["girl","student"]
Example 2:

Input: text = "we will we will rock you", first = "we", second = "will"
Output: ["we","rock"]
 */

class Solution {
    public String[] findOcurrences(String text, String first, String second) {
        ArrayList<String> res = new ArrayList<>();
        
        String[] splited = text.split(" ");
        int n = splited.length;
        
        for(int i = 0; i < n-2; i++){
            if(splited[i].equals(first) && splited[i+1].equals(second)){
                res.add(splited[i+2]);
            }
        }       
        return res.toArray(new String[res.size()]);
    }
}