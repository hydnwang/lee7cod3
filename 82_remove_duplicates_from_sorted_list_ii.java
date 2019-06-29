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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        ListNode curr = head;
        dummy.next = head;
        while(curr != null) {
            
            while(curr.next != null && curr.val == curr.next.val) {
                curr = curr.next;
            }
            
            if(prev.next != curr){
                // this case means there should be duplicate
                // don't move prev forward yet until next iteration
                prev.next = curr.next;
            } else {
                // no duplicate, move prev forward
                prev = prev.next;
            }
            curr = curr.next;
        }
        return dummy.next;
    }
}