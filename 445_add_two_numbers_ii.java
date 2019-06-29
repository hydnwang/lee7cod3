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
        // stack
        ArrayList<Integer> stack1 = new ArrayList<>();
        ArrayList<Integer> stack2 = new ArrayList<>();
        while(l1 != null) {
            stack1.add(l1.val);
            l1 = l1.next;
        }
        while(l2 != null) {
            stack2.add(l2.val);
            l2 = l2.next;
        }
        int s1 = stack1.size() - 1;
        int s2 = stack2.size() - 1;
        int carry = 0;
        ListNode head = null;
        ListNode prev = null;
        while(s1 >= 0 || s2 >= 0 || carry != 0) {
            if(s1 >=0){
                carry += stack1.get(s1--);
            }
            if(s2 >= 0){
                carry += stack2.get(s2--);
            }
            head = new ListNode(carry % 10);
            head.next = prev; 
            prev = head;
            carry /= 10;
        }
        return head;
    }
}