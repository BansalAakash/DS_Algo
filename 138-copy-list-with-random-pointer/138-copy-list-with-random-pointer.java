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
        if(head == null)
            return head;
        Node temp = head;
        while(temp != null){                    //creating new LL by copying
            Node next = temp.next;
            temp.next = new Node(temp.val);
            temp.next.next = next;
            temp = next;
        }
        temp = head;
        while(temp != null){                    //Copying random pointers
            if(temp.random == null)
                temp.next.random = null;
            else
                temp.next.random = temp.random.next;
            temp = temp.next.next;
        }
        temp = head;
        Node newHead = head.next, cur = newHead;
        while(temp != null){                    //separating LLs
            temp.next = temp.next.next;            
            temp = temp.next;
            if(cur.next != null){
                cur.next = cur.next.next;
                cur = cur.next;
            }
        }
        return newHead;
    }
}