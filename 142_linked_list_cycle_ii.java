/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
/* 
Time: O(n)
Space: O(1)
*/
public class Solution {
    public ListNode detectCycle(ListNode head) {
        
        ListNode slow = head;
        ListNode fast = head;
        
        // 1. Detect intersection: traverse fast and slow
        while(fast != null){
            slow = slow.next;
            if(fast.next == null) return null;
            fast = fast.next.next;
            if(slow == fast) break;
        }
        if(fast == null) return null;
        
        // 2. Find entrance: traverse at speed rate
        ListNode finder = head;
        ListNode target = fast;
        while(finder != target){
            finder = finder.next;
            target = target.next;
        }
        return finder;
    }
}