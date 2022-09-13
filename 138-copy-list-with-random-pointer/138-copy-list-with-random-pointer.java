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
        HashMap<Node, Node> map = new HashMap<>();
        Node newHead = null, cur = null, temp = head;
        while(temp != null){
            Node newT = new Node(temp.val);
            if(cur == null){
                cur = newT;
                newHead = newT;
            } else{
                cur.next = newT;
                cur = cur.next;
            }
            map.put(temp, newT);
            temp = temp.next;
        }
        for(Map.Entry<Node, Node> entry: map.entrySet())
            entry.getValue().random = map.get(entry.getKey().random);
        return newHead;
    }
}