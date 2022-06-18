class Solution {
    public Node connect(Node root) {
        Node head = root;
        while(head != null){
            Node cur = head, pre = null, nextHead = null;
            while(cur != null){
                if(cur.left != null){
                    if(pre == null) {
                        pre = cur.left;
                        nextHead = pre;
                    }
                    else{
                        pre.next = cur.left;
                        pre = pre.next;
                    }
                }
                if(cur.right != null){
                    if(pre == null) {
                        pre = cur.right;
                        nextHead = pre;
                    }
                    else{
                        pre.next = cur.right;
                        pre = pre.next;
                    }
                }
                cur = cur.next;
            }
            head = nextHead;
        }
        return root;
    }
}