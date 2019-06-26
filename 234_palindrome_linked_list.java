/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        // find mid
        // time: O(n), space: O(1)
        ListNode mid = findMid(head);
        
        // Reverse the right half of the list
        // time: O(n), space: O(1) 
        ListNode right = reverse(mid);
        
        // compare values from both ends 
        // of head and the right most end.
        // time: O(n), space: O(1) 
        // for odd length: 1->2->3<-2<-1 and 3 will point to null
        // for even length: 1->2->2->null and null<-2<-1
        // when one end reach null, break
        while(head != null && right != null) {
            if(head.val != right.val) {
                return false;
            }
            head = head.next;
            right = right.next;
        }
        return true;
    }
    
    public ListNode findMid(ListNode node) {
        if(node == null || node.next == null) {
            return node;
        }
        ListNode left = node;
        ListNode right = node.next;
        while(right != null && right.next != null) {
            left = left.next;
            right = right.next.next;
        }
        return left;
        
    }
    
    public ListNode reverse(ListNode node){
        ListNode curr = node;
        ListNode prev = null;
        ListNode next = null;
        while(curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}