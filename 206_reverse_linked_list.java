/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode(int x) { val = x; } }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        // Iterative
        // Time: O(n)
        // Space: O(1)
        ListNode curr = head;
        ListNode prev = null;
        ListNode next = null;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        // Recursive
        // Time: O(n)
        // Space: O(n)
        // 1. return head when input list is null
        // 2. return when head.next is null
        // cuz null cannot be the new head
        // so return earlier
        if (head == null || head.next == null) {
            return head;
        }

        ListNode new_head = reverseList(head.next);
        // reverse the direction of current level node
        // and its successor
        head.next.next = head;
        head.next = null;
        // pass new head all the way up
        // to the top level
        return new_head;
    }
}