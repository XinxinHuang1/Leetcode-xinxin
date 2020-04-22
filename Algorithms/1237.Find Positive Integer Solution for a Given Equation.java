/*
 * // This is the custom function interface.
 * // You should not implement it, or speculate about its implementation
 * class CustomFunction {
 *     // Returns f(x, y) for any given positive integers x and y.
 *     // Note that f(x, y) is increasing with respect to both x and y.
 *     // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
 *     public int f(int x, int y);
 * };
 */

class Solution {
    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> res = new ArrayList<>();
        int l = 1, r = 1000;
        while(l <= 1000 && r >= 1){
            int n = customfunction.f(l,r);
            if(n == z){
                res.add(Arrays.asList(l++,r--));
            }
            else if(n < z){
                l++;
            }
            else{
                r--;
            }
        }
        return res;
    }
}