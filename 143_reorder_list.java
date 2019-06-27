/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        
        // 1. find middle point
        ListNode mid = findMid(head);
        // 2. reverse the right half of the list
        // after reversing, the list will split into 2 lists.
        ListNode right = reverse(mid);
        
        ListNode next_head = null;
        ListNode next_right = null;
        
        // for debug: to check we can separate list evenly
        // while(head != null) {
        //     System.out.println("head: " + head.val);
        //     head = head.next;
        // }
        // while(right != null) {
        //     System.out.println("right: " + right.val);
        //     right = right.next;
        // }
        
        // 3. Merge 2 lists
        while(head != null) {
            next_head = head.next;
            next_right = right.next;
            head.next = right;        
            right.next = next_head;
            head = next_head;
            right = next_right;
        }
    }
    
    public ListNode findMid(ListNode node) {
        if(node == null || node.next == null) return node;
        ListNode slow = node;
        ListNode fast = slow.next; // middle to the left, fast = slow middle to the right
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    public ListNode reverse(ListNode node) {
        if(node == null || node.next == null) return node;
        ListNode curr = node;
        ListNode next = null;
        ListNode prev = null;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}