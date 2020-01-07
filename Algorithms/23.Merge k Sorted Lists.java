/*23. Merge k Sorted Lists

Share
Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

Example:

Input:
[
  1->4->5,
  1->3->4,
  2->6
]*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

 //Solution: Priority Queue
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        
        Comparator<ListNode> cmp;
        cmp = new Comparator<ListNode>(){
            @Override
            public int compare(ListNode n1, ListNode n2){
                return n1.val - n2.val;
                }
        };
        
        Queue<ListNode> q = new PriorityQueue<>(cmp);
        for(ListNode node : lists){
            if(node != null){
                q.add(node);
            }
        }
        ListNode head = new ListNode(0);
        ListNode point = head;
        while(!q.isEmpty()){
            point.next = q.poll();
            point = point.next;
            ListNode next = point.next;
            if(next != null){
                q.add(next);
            }
        }
        return head.next;
    }
}