/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<Node> cur = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) return result;
        cur.add(root);
        while(cur.size() > 0){
            int size = cur.size();
            List<Integer> temp = new ArrayList<>();
            while(size-- > 0){
                Node node = cur.remove(0);
                temp.add(node.val);
                for(Node child : node.children) cur.add(child);
            }
            result.add(temp);
        }
        return result;
    }
}