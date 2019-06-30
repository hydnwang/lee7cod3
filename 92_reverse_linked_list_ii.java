/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/* 
Time: O(n) n is the end of the reversing point
Space: O(1)
*/
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        // 1. front -> tail -> ... -> (prev) -> (curr)
        // 2. front -> tail <- ... <- (prev) -> (curr)
        // 3. front -> (prev) -> ... -> tail -> (curr)
        if(head == null) return head;
        int i = 1;
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        
        while(i < m) {
            i++;
            prev = curr;
            curr = curr.next;
        }
        
        // reverse
        ListNode front = prev;
        ListNode tail = curr;
        while(i <= n) {
            i++;
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        if(front != null)
            front.next = prev;
        else
            head = prev;
        tail.next = curr;
        return head;
    }
}