/**
 Given a sorted array, two integers k and x, find the k closest elements to x in the array. The result should also be sorted in ascending order. If there is a tie, the smaller elements are always preferred.

Example 1:
Input: [1,2,3,4,5], k=4, x=3
Output: [1,2,3,4]
Example 2:
Input: [1,2,3,4,5], k=4, x=-1
Output: [1,2,3,4]
 */

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int l = 0, r = arr.length - k;
        while(l < r){
            int mid = (l + r) / 2;
            if(x - arr[mid] > arr[mid + k] - x)
                l = mid + 1;
            else
                r = mid;
        }
        List<Integer> res = new ArrayList<Integer>();
        for(int i = l; i < l + k; i++){
            res.add(arr[i]);
        }
        return res;
    }
}