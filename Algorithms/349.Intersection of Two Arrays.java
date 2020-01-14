/* 349. Intersection of Two Arrays
Given two arrays, write a function to compute their intersection.

Example 1:

Input: nums1 = [1,2,2,1], nums2 = [2,2]
Output: [2]
Example 2:

Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
Output: [9,4]
Note:

Each element in the result must be unique.
The result can be in any order.
*/

//Time  average O(n+m), worst O(n*m)
// Space O(n+m)
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        for(int i : nums1){
            set1.add(i);
        }
        for(int i : nums2){
            set2.add(i);
        }
        set1.retainAll(set2);//save all common int to set1
        
        int[] ans = new int[set1.size()];
        int i = 0;
        for(int x : set1){
            ans[i++] = x;
        }
        return ans;
    }
}

/*
Q. What if the given array is already sorted? How would you optimize your algorithm?

If both arrays are sorted, I would use two pointers to iterate, which somehow resembles the merge process in merge sort.

Q. What if nums1's size is small compared to nums2's size? Which algorithm is better?

Suppose lengths of two arrays are N and M, the time complexity of my solution is O(N+M) and the space complexity if O(N) considering the hash. So it's better to use the smaller array to construct the counter hash.

Well, as we are calculating the intersection of two arrays, the order of array doesn't matter. We are totally free to swap to arrays.

Q. What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?

Divide and conquer. Repeat the process frequently: Slice nums2 to fit into memory, process (calculate intersections), and write partial results to memory.

*/
//Solution 2: without hashmap
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        for(int i = 0; i < nums1.length; i++){
            for(int j = 0; j < nums2.length; j++){
                if(nums1[i] == nums2[j]){
                   if(list.size() == 0){
                       list.add(nums1[i]);
                   }
                   else if(list.get(list.size()-1) != nums1[i]){
                       list.add(nums1[i]);
                   }
                }
            }
        }
        int[] ans = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            ans[i] = list.get(i);
        }
        return ans;
    }
}