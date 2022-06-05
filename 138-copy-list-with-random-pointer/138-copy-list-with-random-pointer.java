/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;
        //Loop 1 -> Duplicate all nodes
        Node temp = head;
        while(temp != null){
            Node next = temp.next;
            temp.next = new Node(temp.val);
            temp.next.next = next;
            temp = temp.next.next;
        }
        
        //Loop 2 -> Update all random pointers of the new nodes
        temp = head;
        while(temp != null) {
            if(temp.random != null)
                temp.next.random = temp.random.next;
            temp = temp.next.next;
        }
        
        //Loop3 -> Separate the new list out
        Node newHead = head.next;
        temp = head;
        Node newTemp = newHead;
        while(temp != null && temp.next != null){
            temp.next = temp.next.next;
            temp = temp.next;
            
            if(newTemp.next != null)
                newTemp.next = newTemp.next.next;
            newTemp = newTemp.next;
        }
        return newHead;
    }
}