/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Node implements Comparable<Node>{
    TreeNode node;
    int level;
    public Node(TreeNode n, int l){
        node = n;
        level = l;
    }
    public int compareTo(Node n1){
        if(level == n1.level)
            return node.val - n1.node.val;
        return level - n1.level;
    }
}
class Solution {
    int helper(TreeNode root, HashMap<Integer, PriorityQueue<Node>> map, int h_dist, int level){
        if(root == null) return Integer.MAX_VALUE;
        PriorityQueue<Node> q = map.getOrDefault(h_dist, new PriorityQueue<>());
        q.add(new Node(root, level));
        map.put(h_dist, q);
        int left = helper(root.left, map, h_dist - 1, level + 1);
        int right = helper(root.right, map, h_dist + 1, level + 1);
        return Math.min(h_dist, Math.min(left, right));
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        HashMap<Integer, PriorityQueue<Node>> map = new HashMap<>();
        int i = helper(root, map, 0, 0);           // i stores the lowest h_dist
        List<List<Integer>> result = new ArrayList<>();
        while(map.containsKey(i)){
            PriorityQueue<Node> q = map.get(i);
            ArrayList<Integer> list = new ArrayList<>();
            while(!q.isEmpty())
                list.add(q.poll().node.val);
            result.add(list);
            i++;
        }
        return result;
    }
}