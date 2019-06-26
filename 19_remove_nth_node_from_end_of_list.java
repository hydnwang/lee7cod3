/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/* 
Time: O(n)
Space: O(1)
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = fast;
        for(int i = 0; i < n; i++) {
            fast = fast.next;
        }
        // corner case: n == length of the list
        if(fast == null) {
            return head.next;
        }
        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return head;
        
    }
}