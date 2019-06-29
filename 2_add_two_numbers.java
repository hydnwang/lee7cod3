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
Space: O(n)
*/
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        ListNode node = null;
        int carry = 0;
        while(l1 != null || l2 != null || carry != 0) {
            if(l1 != null) {
                carry += l1.val;
                l1 = l1.next;
            }
            if(l2 != null) {
                carry += l2.val;
                l2 = l2.next;
            }
            
            head.next = new ListNode(carry % 10);
            head = head.next;
            carry /= 10;
        }
        return dummy.next;
    }
}