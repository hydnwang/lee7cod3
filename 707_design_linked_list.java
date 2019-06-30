class ListNode {
    int val;
    ListNode next;
    public ListNode(int x) {
        this.val = x;
    }
}

class MyLinkedList {
    ListNode head;
    int size;
    
    /** Initialize your data structure here. */
    public MyLinkedList() {
        this.head = null;
        this.size = 0;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index < 0 || index >= size) return -1;
        if(head == null) return -1;
        
        ListNode curr = head;
        for(int i = 0; i < index; i++){
            curr = curr.next;
        }
        return curr.val;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        addAtIndex(0, val);
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        addAtIndex(size, val);
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        // to solve weird test case when index given is less than 0 (-1)
        // if(index < 0 || index > size) return;
        if(index > size) return;
        
        size++;
        ListNode x = new ListNode(val);
        
        if(index <= 0) { // add at head
            x.next = head;
            head = x;
        } else { // add at tail or any position but head
            ListNode curr = head;
            for(int i = 0; i < index-1; i++) {
                curr = curr.next;
            }
            x.next = curr.next;
            curr.next = x;
        }
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index < 0 || index >= size) return;
        
        size--;
        ListNode curr = head;
        if(index == 0) {
            head = curr.next;
        } else {
            for(int i = 0; i < index-1; i++) {
                curr = curr.next;
            }
            curr.next = curr.next.next;
        }
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */