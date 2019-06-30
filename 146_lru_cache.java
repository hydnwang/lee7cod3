class Node {
    Node prev, next;
    int key, val;
    public Node(int k, int v) {
        this.key = k;
        this.val = v;
    }
}

class LRUCache {

    int capacity;
    Map<Integer, Node> map;
    Node head = new Node(0, 0);
    Node tail = new Node(0, 0);
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap(capacity);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        // 1. check key in map
        // 2. if it exists
        //    -> remove from the queue
        //    -> add it to the head of queue
        //    -> return node.val
        // 3. else return -1
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            insertAtHead(node);
            return node.val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        // 1. check the key in map
        // 2. if it exists
        //    -> remove from the queue
        //    -> add it to the head of queue
        //    -> update node.val
        // 3. else
        //    -> create new node(key, value)
        //    -> add it to the head of queue
        if (map.containsKey(key)) {
            Node node = map.get(key);
            remove(node);
            insertAtHead(node);
            node.val = value;
        } else {
            if (map.size() == capacity) {
                map.remove(tail.prev.key);
                remove(tail.prev);
            }
            Node node = new Node(key, value);
            insertAtHead(node);
            map.put(key, node);
        }
    }
    
    // healper func: remove
    public void remove(Node node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }
    // healper func: insert at head
    public void insertAtHead(Node node) {
        Node next = head.next;
        head.next = node;
        node.next = next;
        node.prev = head;
        next.prev = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */