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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr = dummy;
        ListNode first = null;
        ListNode second = null;
        
        // 0    ->   1   ->  2    -> 3 -> 4
        // curr    first   second
        // 0    ->   2   ->       1      -> 3 -> 4
        // curr    second  first(new curr)
        // by using a dummy node, we won't interfere the swapping.
        while(curr.next != null && curr.next.next != null) {
            first = curr.next;
            second = curr.next.next;
            first.next = second.next;
            second.next = first;
            curr.next = second;
            curr.next.next = first;
            curr = first;
        }
        return dummy.next;
    }
}