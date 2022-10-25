/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/
class Solution {
    public Node cloneGraph(Node node) {
        if(node == null)
            return null;
        HashMap<Node, Node> map = new HashMap<>();
        HashSet<Node> visited = new HashSet<>();
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        while(!q.isEmpty()){
            Node cur = q.poll();
            map.put(cur, new Node(cur.val));
            visited.add(cur);
            for(Node n : cur.neighbors)
                if(!visited.contains(n))
                    q.add(n);
        }
        for(Node n : map.keySet()){
            Node cur = map.get(n);
            for(Node x : n.neighbors)
                cur.neighbors.add(map.get(x));
        }
        return map.get(node);
    }
}