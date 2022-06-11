class ListNode{
    ListNode next;
    int val;
    public ListNode(int value){
        val = value;
    }
}

class MyCircularQueue {
    ListNode front, rear;
    int size, capacity;
    public MyCircularQueue(int k) {
        front = null;
        rear = null;
        size = 0;
        capacity = k;
    }
    
    public boolean enQueue(int value) {
        if(size == capacity) return false;
        ListNode temp = new ListNode(value);
        if(size == 0){
            front = temp;
            rear = front;
            front.next = rear;
        } else{
            temp.next = front;
            rear.next = temp;
            rear = rear.next;
        }
        size++;
        return true;
    }
    
    public boolean deQueue() {
        if(size == 0) return false;
        if(size == 1){
            front = null;
            rear = null;
        }else{
            front = front.next;
            rear.next = front;    
        }
        size--;
        return true;
    }
    
    public int Front() {
        return size == 0 ? -1 : front.val;
    }
    
    public int Rear() {
        return size == 0 ? -1 : rear.val;
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public boolean isFull() {
        return size == capacity;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */