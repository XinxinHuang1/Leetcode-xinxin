//source: https://leetcode.com/problems/add-two-numbers/
// @Xinxin Huang
// 2019-03-07

/******************************************************
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 ********
 *Example:

 Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 0 -> 8
 Explanation: 342 + 465 = 807.

 ******************************************************/

 /**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */


public class AddTwoNumbers_Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2){
        ListNode dummy = new ListNode(0);
        ListNode l3 = dummy;
        int carry = 0;

        while(l1 != null && l2 != null){
            int digit = (l1.val + l2.val + carry) % 10;
            carry = (l1.val + l2.val + carry) / 10;
            ListNode newNode = new ListNode(digit);
            l3.next = newNode;
            l3 = newNode;
            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1 != null){
            int digit = (l1.val + carry) % 10;
            carry = (l1.val + carry) / 10;
            ListNode newNode = new ListNode(digit);
            l3.next = newNode;
            l3 = newNode;
            l1 = l1.next;
        }

        while(l2 != null){
            int digit = (l2.val + carry) % 10;
            carry = (l2.val + carry) % 10;
            ListNode newNode = new ListNode(digit);
            l3.next = newNode;
            l3 = newNode;
            l2 = l2.next;
        }

        if(carry > 0){
            ListNode newNode = new ListNode(carry);
            l3.next = newNode;
            l3 = newNode;
        }
        return dummy.next;
    }

}
