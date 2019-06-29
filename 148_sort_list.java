/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/* 
Time: O(nlogn)
Space: O(n)
*/
class Solution {
    public ListNode sortList(ListNode head) {
        // 1. base case
        if(head == null || head.next == null) return head;
        
        // 2. Split list into 2: head to mid and the right half
        ListNode mid = splitList(head);
        ListNode right = mid.next;
        mid.next = null;
        
        // 3. Recursive merge both lists
        ListNode a = sortList(head);
        ListNode b = sortList(right);
        
        // 4. Merge lsit
        return mergeList(a, b);
    }
    
    public ListNode splitList(ListNode node) {
        ListNode slow = node;
        ListNode fast = node.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    public ListNode mergeList(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        
        while(a != null && b != null) {
            if(a.val > b.val){
                curr.next = b;
                b = b.next;
            } else {
                curr.next = a;
                a = a.next;
            }
            curr = curr.next;
        }
        if(a != null) curr.next = a;
        if(b != null) curr.next = b;
        return dummy.next;
    }
}