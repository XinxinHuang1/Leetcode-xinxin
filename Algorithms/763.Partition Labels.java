/*Medium
A string S of lowercase letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts.

Example 1:
Input: S = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
Note:

S will have length in range [1, 500].
S will consist of lowercase letters ('a' to 'z') only.
*/

//Time O(N) Space O(1)
//greedy
class Solution {
    public List<Integer> partitionLabels(String S) {
        int[] last = new int[26];
        for(int i = 0; i < S.length(); i++){
            last[S.charAt(i) - 'a'] = i;
        }
        List<Integer> ans = new ArrayList<>();
        int index = 0, next = 0;
        for(int i = 0; i < S.length(); i++){
            index = Math.max(index, last[S.charAt(i) - 'a']);
            if(i == index){
                ans.add(i - next + 1);
                next = i + 1;
            }
        }
        return ans;
    }
}

/*
012345678 9
ababcbaca defegdehijhklij
a:
last[0] = 8;
index = 8;
*/