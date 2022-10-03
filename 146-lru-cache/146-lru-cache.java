class Node{
    Node next, prev;
    int key, val;
    public Node(int key, int val){
        this.key = key;
        this.val = val;
    }
}
class LRUCache {
    int cap, size;
    HashMap<Integer, Node> map;
    Node head, tail;
    public LRUCache(int capacity) {
        cap = capacity;
        map = new HashMap<>();
    }
    public int get(int key) {
        if(!map.containsKey(key))
            return -1;
        bringNodeToFron(map.get(key));
        return head.val;
    }
    void bringNodeToFron(Node temp){
        if(temp != head){
            if(temp == tail){
                if(temp.next != null)
                    tail = temp.next;
                else tail = temp.prev;
            }
            temp.prev.next = temp.next;
            if(temp.next != null)
                temp.next.prev = temp.prev;
            temp.prev = null;
            head.prev = temp;
            temp.next = head;
            head = temp;
        }
    }
    public void put(int key, int value) {
        if(map.containsKey(key)){
            map.get(key).val = value;
            bringNodeToFron(map.get(key));
            return;
        }
        if(size == cap) {
            map.remove(tail.key);
            if(cap == 1) {
                head = null;
                tail = null;
            } else {
                tail = tail.prev;
                tail.next = null;
            }
            size--;
        }
        
        Node temp = new Node(key, value);
        map.put(key, temp);
        
        if(head == null){
            head = temp;
            tail = temp;
        } else{
            temp.next = head;
            head.prev = temp;
            head = temp;
        }
        size++;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */