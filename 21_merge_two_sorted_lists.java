/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 1. Iterative
        /* 
        Time: O(n)
        Space: O(1)
        */
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while(l1 != null && l2 != null) {
            if(l1.val > l2.val) {
                curr.next = l2;
                l2 = l2.next;
            } else {
                curr.next = l1;
                l1 = l1.next;
            }
            curr = curr.next;
        }
        if(l1 != null) curr.next = l1;
        if(l2 != null) curr.next = l2;
        return dummy.next;
        
        // 2. Recursive
        /* 
        Time: O(n)
        Space: O(n)
        */
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode dummy = null;
        if(l1.val > l2.val){
            dummy = new ListNode(l2.val);
            dummy.next = mergeTwoLists(l1, l2.next);
        } else {
            dummy = new ListNode(l1.val);
            dummy.next = mergeTwoLists(l1.next, l2);
        }
        return dummy;
    }
}