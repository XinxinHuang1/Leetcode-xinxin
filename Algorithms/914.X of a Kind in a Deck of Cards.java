/*

In a deck of cards, each card has an integer written on it.

Return true if and only if you can choose X >= 2 such that it is possible to split the entire deck into 1 or more groups of cards, where:

Each group has exactly X cards.
All the cards in each group have the same integer.
 

Example 1:

Input: deck = [1,2,3,4,4,3,2,1]
Output: true
Explanation: Possible partition [1,1],[2,2],[3,3],[4,4].
Example 2:

Input: deck = [1,1,1,2,2,2,3,3]
Output: false´
Explanation: No possible partition.
Example 3:

Input: deck = [1]
Output: false
Explanation: No possible partition.
Example 4:

Input: deck = [1,1]
Output: true
Explanation: Possible partition [1,1].
Example 5:

Input: deck = [1,1,2,2,2,2]
Output: true
Explanation: Possible partition [1,1],[2,2],[2,2]. */

//Time O(Nlog ^2 N) each gcd operation is Log^2 N        Space O(n)
class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
        int n = deck.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int d : deck){
            map.put(d, map.getOrDefault(d, 0) + 1);
        }
        int res = 0;
        for(int val : map.values()){
            res = gcd(val, res);
        }
        return res > 1;
    }
    // find greatest common divisor
    public int gcd(int a, int b){
        return b == 0 ? a : gcd(b, a % b);
    }
}
