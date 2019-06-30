class Node {
    Node next;
    int key, val;
    Node(int key, int value) {
        this.key = key;
        this.val = value;
    }
}

class MyHashMap {
    
    int size = 10000;
    Node[] hashTable = new Node[size];

    /** Initialize your data structure here. */
    public MyHashMap() {
        
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int idx = hash(key);
        Node node = hashTable[idx];
        if (node == null) {
            hashTable[idx] = new Node(key, value);
        } else {
            while (node != null) {
                if (node.key == key) {
                    node.val = value;
                    return;
                }
                if (node.next == null) break;
                node = node.next;
            }
            node.next = new Node(key, value);
        }
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int idx = hash(key);
        Node node = hashTable[idx];
        
        while (node != null) {
            if (node.key == key) return node.val;
            node = node.next;
        }
        return -1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int idx = hash(key);
        Node node = hashTable[idx];
        if (node == null) return;
        if (node.key == key) {
            hashTable[idx] = node.next;
        } else {
            Node prev;
            while (node != null) {
                prev = node;
                node = node.next;
                if (node == null) return;
                if (node.key == key) {
                    prev.next = node.next;
                    return;
                }
            }
        }
    }
    
    int hash(int key) { return key % size; }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */