class Solution {
    public Node connect(Node root) {
        if(root == null)
            return root;
        Node leftest = root;
        while(leftest != null){
            Node prev = null, nextLeft = null;
            for(Node cur = leftest;cur != null;cur = cur.next){
                if(cur.left != null){
                    if(prev == null){
                        prev = cur.left;
                        nextLeft = prev;
                    }
                    else{
                        prev.next = cur.left;
                        prev = prev.next;
                    }
                }
                if(cur.right != null){
                    if(prev == null){
                        prev = cur.right;
                        nextLeft = prev;
                    }
                    else{
                        prev.next = cur.right;
                        prev = prev.next;
                    }
                }
            }
            leftest = nextLeft;
        }
        return root;
    }
}