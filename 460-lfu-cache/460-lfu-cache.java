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
class DLL{
    Node head, tail;                        //pseudo
    int size;
    public DLL(){
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }
    void insert(Node node){
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
        size++;
    }
    void removeNode(Node node){
        Node temp = node.prev;
        temp.next = node.next;
        node.next.prev = temp;
        size--;
    }
}
class LFUCache {
    int cap, minFreq, size;
    HashMap<Integer, Node> nodeMap;
    HashMap<Integer, DLL> freqMap;
    public LFUCache(int capacity) {
        cap = capacity;
        nodeMap = new HashMap<>();
        freqMap = new HashMap<>();
        minFreq = 1;
    }
    void remove(Node node){
        freqMap.get(node.use).removeNode(node);
        nodeMap.remove(node.key);
        size--;
    }
    void add(Node node){
        DLL temp = null;
        if(!freqMap.containsKey(minFreq) || freqMap.get(minFreq).size == 0)
            minFreq = node.use;
        if(freqMap.containsKey(node.use))
            temp = freqMap.get(node.use);
        else {
            temp = new DLL();
            freqMap.put(node.use, temp);
        }
        temp.insert(node);
        nodeMap.put(node.key, node);
        size++;
    }
    void update(Node node){
        remove(node);
        node.use++;
        add(node);
    }
    public int get(int key) {
        if(!nodeMap.containsKey(key))
            return -1;
        update(nodeMap.get(key));
        return nodeMap.get(key).value;
    }
    
    public void put(int key, int value) {
        if(cap == 0)
            return;
        if(nodeMap.containsKey(key)){
            Node node = nodeMap.get(key);
            node.value = value;
            update(node);
        } else{
            if(size == cap)
                remove(freqMap.get(minFreq).tail.prev);
            Node node = new Node(key, value);
            add(node);
            minFreq = 1;
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */