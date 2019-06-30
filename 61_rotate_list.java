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
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null) return head;
        
        ListNode slow = head;
        ListNode fast = head;
        ListNode scout = head;
        // 1. find length and actual shifting position
        int len = 0;
        while (scout != null) {
            len++;
            scout = scout.next;
        }
        int shift = k % len;
        
        // if k == length
        if (shift == 0) return head;
        
        // 2. fast pointer starts first
        for (int i = 0; i < shift; i++) {
            fast = fast.next;
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        
        // 3. reconnect the list
        fast.next = head;
        head = slow.next;
        slow.next = null;
        return head;
    }
}