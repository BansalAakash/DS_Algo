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
    void dfs(HashMap<Node, Node> map, HashSet<Node> visited, Node node){
        if(visited.contains(node))
            return;
        visited.add(node);
        map.put(node, new Node(node.val));
        for(Node n : node.neighbors)
            dfs(map, visited, n);
    }
    public Node cloneGraph(Node node) {
        if(node == null)
            return null;
        HashMap<Node, Node> map = new HashMap<>();
        dfs(map, new HashSet<>(), node);
        for(Node n : map.keySet()){
            Node cur = map.get(n);
            for(Node x : n.neighbors)
                cur.neighbors.add(map.get(x));
        }
        return map.get(node);
    }
}