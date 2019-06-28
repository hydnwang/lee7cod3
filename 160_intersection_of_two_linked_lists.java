/**
 * Definition for singly-linked list.
 * public class ListNode {
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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;
        
        // if the 2 lists are not the same in length,
        // connect each list to each other: ListA -> ListB, ListB -> ListA
        // while traversing the list, they will travel the same distance
        // and meet at the intersection
        while(curA != curB){
            if(curA == null){
                curA = headB;
            } else {
                curA = curA.next;
            }
            
            if(curB == null){
                curB = headA;
            } else {
                curB = curB.next;
            }
        }
        return curA;
    }
}