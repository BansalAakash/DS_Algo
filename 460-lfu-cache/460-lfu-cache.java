class Node{
    Node next, prev;
    int key, value, use;
    public Node(){}
    public Node(int key, int value){
        this.key = key;
        this.value = value;
        this.use = 1;
    }
}
class LFUCache {
    Node head, tail;                            //head and tail are pseudo
    int cap, size;
    HashMap<Integer, Node> map;
    public LFUCache(int capacity) {
        cap = capacity;
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
    }
    void update(Node node){
        remove(node);
        add(node);
    }
    void remove(Node node){
        // System.out.println("Removing " + node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
        map.remove(node.key);
        size--;
    }
    void add(Node node){
        // System.out.println("Adding " + node.key);
        Node temp = head.next;
        while(temp != tail && temp.use > node.use)
            temp = temp.next;
        temp.prev.next = node;
        node.prev = temp.prev;
        node.next = temp;
        temp.prev = node;
        map.put(node.key, node);
        size++;
    }
    public int get(int key) {
        // System.out.print("Searching " + key);
        if(!map.containsKey(key)){
            // System.out.println(". Not Found");
            return -1;
        }
        // System.out.println(". Found, updating use counter");
        map.get(key).use += 1;
        update(map.get(key));
        return map.get(key).value;
    }
    
    public void put(int key, int value) {
        if(cap == 0)
            return;
        if(map.containsKey(key)){
            map.get(key).use += 1;
            map.get(key).value = value;
            update(map.get(key));
            return;
        }
        if(size == cap){
            // System.out.print("Evicting " + tail.prev.key + ". ");
            remove(tail.prev);
        }
        Node node = new Node(key, value);
        add(node);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */