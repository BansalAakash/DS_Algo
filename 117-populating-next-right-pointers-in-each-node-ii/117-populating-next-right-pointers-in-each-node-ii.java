class Solution {
    public Node connect(Node root) {
        Node head = root;
        while(head != null){
            Node cur = head, pre = null, nextHead = null;
            while(cur != null){
                if(cur.left != null){
                    if(pre == null) 
                        pre = cur.left;
                    else{
                        pre.next = cur.left;
                        pre = pre.next;
                    }
                }
                if(nextHead == null) nextHead = pre;
                if(cur.right != null){
                    if(pre == null) 
                        pre = cur.right;
                    else{
                        pre.next = cur.right;
                        pre = pre.next;
                    }
                }
                if(nextHead == null) nextHead = pre;
                cur = cur.next;
            }
            head = nextHead;
        }
        return root;
    }
}