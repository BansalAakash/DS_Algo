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
        HashMap<Node, Integer> map = new HashMap<>();
        int i = 0;
        Node temp = head;
        while(temp != null){
            map.put(temp, i++);
            temp = temp.next;
        }
        HashMap<Integer, Node> newMap = new HashMap<>();i = 1;
        Node newHead = new Node(head.val), newTemp = newHead; temp = head.next;
        newMap.put(0, newHead);
        while(temp != null){
            newTemp.next = new Node(temp.val);
            newMap.put(i++, newTemp.next);
            newTemp = newTemp.next;
            temp = temp.next;
        }
        temp = head;
        for(int j = 0;j < i;j++){
            if(temp.random != null)
                newMap.get(j).random = newMap.get(map.get(temp.random));
            temp = temp.next;
        }
        return newHead;
    }
}