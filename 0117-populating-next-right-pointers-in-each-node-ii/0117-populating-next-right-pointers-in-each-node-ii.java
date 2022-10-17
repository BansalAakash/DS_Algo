class Solution {
    public Node connect(Node root) {
        if(root == null)
            return root;
        Node leftest = root;
        while(leftest != null){
            Node prev = null, nextLeft = null;
            for(Node cur = leftest;cur != null;cur = cur.next){
                if(prev == null){
                    if(cur.left != null){
                        prev = cur.left;
                        nextLeft = prev;
                    }
                    else if(cur.right != null){
                        prev = cur.right;
                        nextLeft = prev;
                    }
                }
                if(prev != null) {
                    if(cur.left != null && cur.left != prev){
                        prev.next = cur.left;
                        prev = prev.next;
                    }
                    if(cur.right != null && cur.right != prev){
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