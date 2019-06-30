/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Solution 1: Divide & Conquer
 * 1. Recursively partion lists into pairs
 * 2. merge each pair and backtrack
*/ 
/**
 * Solution 2: Heap (Priority Queue)
 * 1. create custom comparator for heap to compare node.val
 * 2. push head nodes in lists to heap
 * 3. pop nodes and connect, push node.next if node.next exists.
*/ 

class Solution {
    private Comparator<ListNode> customComparator = new Comparator<ListNode>() {
        public int compare(ListNode left, ListNode right) {
            return left.val - right.val;
        }
    };
    
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        
        // Solution1: Divide & Conquer
        // Time: O(nlogk) where k is the number of list in lists
        // Space: O(1) if not considering the call stack, else O(k)
        return partition(lists, 0, lists.length - 1);
        
        // Solution2: Heap
        // Time: O(nlogk) where k is the number of list in lists
        // Space: O(n + k), where n is for new linked list and k is for holding the heap
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        Queue<ListNode> heap = new PriorityQueue<ListNode>(lists.length, customComparator);
        for(int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                heap.add(lists[i]);
            }
        }
        ListNode node;
        while (!heap.isEmpty()) {
            node = heap.poll();
            if (node.next != null) {
                heap.add(node.next);
            }
            head.next = node;
            head = head.next;
        }
        return dummy.next;
    }
    
    // Divide & Conquer: helper function
    ListNode partition(ListNode[] lists, int start, int end) {
        if(start == end) {
            return lists[start];
        }
        int mid = start + (end - start) / 2;
        ListNode left = partition(lists, start, mid);
        ListNode right = partition(lists, mid+1, end);
        return merge(left, right);
    }
    ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val > l2.val) {
                head.next = l2;
                l2 = l2.next;
            } else {
                head.next = l1;
                l1 = l1.next;
            }
            head = head.next;
        }
        if (l1 != null) head.next = l1;
        if (l2 != null) head.next = l2;
        return dummy.next;
    }
}