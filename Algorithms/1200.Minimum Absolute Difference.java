/*
Given an array of distinct integers arr, find all pairs of elements with the minimum absolute difference of any two elements. 

Return a list of pairs in ascending order(with respect to pairs), each pair [a, b] follows

a, b are from arr
a < b
b - a equals to the minimum absolute difference of any two elements in arr
 

Example 1:

Input: arr = [4,2,1,3]
Output: [[1,2],[2,3],[3,4]]
Explanation: The minimum absolute difference is 1. List all pairs with difference equal to 1 in ascending order.
Example 2:

Input: arr = [1,3,6,10,15]
Output: [[1,3]]
Example 3:

Input: arr = [3,8,-10,23,19,-4,-14,27]
Output: [[-14,-10],[19,23],[23,27]] */

class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);        
        int mindiff = Integer.MAX_VALUE;
        for(int i = 1; i < arr.length; i++){
            if(arr[i] - arr[i-1] < mindiff)
                mindiff = arr[i] - arr[i-1];
        }        
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 1; i < arr.length; i++){
            if(arr[i] - arr[i-1] == mindiff){
                List<Integer> list = new ArrayList<>();
                list.add(arr[i-1]);
                list.add(arr[i]);
                res.add(list);
            }
        }
        return res;
    }
}

//same idea using hashmap(not necessary, slower)
class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort(arr);
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(arr[0], 0);
        int mindiff = Integer.MAX_VALUE;
        for(int i = 1; i < arr.length; i++){
            map.put(arr[i], i);
            if(arr[i] - arr[i-1] < mindiff)
                mindiff = arr[i] - arr[i-1];
        }        
        List<List<Integer>> res = new ArrayList<>();
        for(int key : map.keySet()){
            List<Integer> list = new ArrayList<>();
            if(map.containsKey(key - mindiff) && map.get(key) != map.get(key - mindiff)){
                list.add(key - mindiff);
                list.add(key);
                res.add(list);
            }
        }
        Collections.sort(res, (a, b) -> a.get(0) - b.get(0));
        return res;
    }
}

// 1 2 3 4 