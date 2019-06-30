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
Space: O()
*/
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head==null || head.next==null || k==1) return head;
        // begin -> ... -> end
        ListNode dummy = new ListNode(0);
        ListNode begin = dummy;
        ListNode end;
        dummy.next = head;
        int i = 0;
        while (head != null) {
            i++;
            if (i % k == 0) {
                // reverse
                begin = reverse(begin, head.next);
                head = begin.next;
            } else {
                head = head.next;
            }
        }
        return dummy.next;
    }
    public ListNode reverse(ListNode begin, ListNode end) {
        ListNode prev = begin;
        ListNode curr = begin.next;
        ListNode new_begin = curr;
        ListNode next;
        while (curr != end) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        begin.next = prev;
        new_begin.next = curr;
        return new_begin;
    }
}