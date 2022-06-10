class ListNode{
    ListNode next;
    int val;
    public ListNode(int val){
        next = null;
        this.val = val;
    }
}


class MyLinkedList {
    ListNode head;
    int size;
    public MyLinkedList() {
        head = new ListNode(-1);
        size = 0;
    }
    
    public int get(int index) {
        if(index >= size) return -1;
        ListNode temp = head;
        while(index-- >= 0) temp = temp.next;
        return temp.val;
    }
    
    public void addAtHead(int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = head.next;
        head.next = newNode;
        size++;
    }
    
    public void addAtTail(int val) {
        ListNode newNode = new ListNode(val), temp = head;
        while(temp.next != null) temp = temp.next;
        temp.next = newNode;
        size++;
    }
    
    public void addAtIndex(int index, int val) {
        if(index > size) return;
        ListNode temp = head;
        ListNode newNode = new ListNode(val);
        while(index-- > 0) temp = temp.next;
        newNode.next = temp.next;
        temp.next = newNode;
        size++;
    }
    
    public void deleteAtIndex(int index) {
        if(index >= size) return;
        ListNode temp = head;
        while(index-- > 0) temp = temp.next;
        temp.next = temp.next.next;
        size--;
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