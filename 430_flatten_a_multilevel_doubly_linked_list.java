/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {}

    public Node(int _val,Node _prev,Node _next,Node _child) {
        val = _val;
        prev = _prev;
        next = _next;
        child = _child;
    }
};
*/
/* 
Time: O(n)
Space: O(1)
*/
class Solution {
    
    public Node flatten(Node head) {
        if(head == null) return head;
        
        Node curr = head;
        Node scout;
        
        while (curr != null) {
            // 1. No child, keep moving forward
            if (curr.child == null) {
                curr = curr.next;
                continue;
            }
            
            // 2. child found, send out a scout
            // to flatten this and only this level
            scout = curr.child;
            while (scout.next != null) {
                scout = scout.next;
            }
            // tail found, connect tail with curr.next
            scout.next = curr.next;
            if(curr.next != null) {
                curr.next.prev = scout;
            }
            curr.next = curr.child;
            curr.child.prev = curr;
            curr.child = null;
        }
        return head;
    }
}