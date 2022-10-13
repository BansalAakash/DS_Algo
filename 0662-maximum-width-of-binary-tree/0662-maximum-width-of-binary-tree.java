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
class Solution {
    void helper(HashMap<Integer, long[]> map, TreeNode root, int level, long h_dist){
        if(root == null) return;
        if(map.containsKey(level)){
            long[] temp = map.get(level);
            temp[0] = Math.min(temp[0], h_dist);
            temp[1] = Math.max(temp[1], h_dist);
        } else {
            long[] temp = {h_dist, h_dist};
            map.put(level, temp);
        }
        helper(map, root.left, level + 1, h_dist * 2 - 1);
        helper(map, root.right, level + 1, h_dist * 2 + 1);
    }
    public int widthOfBinaryTree(TreeNode root) {
        HashMap<Integer, long[]> map = new HashMap<>();
        int max = 1, i = 0;
        helper(map, root, 0, 0);
        while(map.containsKey(i)){
            long[] temp = map.get(i);
            int cur = (int)((temp[1] - temp[0]) / 2 + 1);
            max = Math.max(max, cur);
            i++;
        }
        return max;
    }
}