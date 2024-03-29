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
    void helper(TreeNode root, List<List<Integer>> list, int level, boolean flag){ //true means left to right, false means vv
        if(root == null) return;
        
        if(list.size() <= level)
            list.add(new LinkedList<>());
        
        if(flag)                           //l2r
            ((LinkedList<Integer>)list.get(level)).addFirst(root.val);
        else                                //r2l
            list.get(level).add(root.val);
        helper(root.right, list, level + 1, !flag);
        helper(root.left, list, level + 1, !flag);
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        helper(root, list, 0, true);
        return list;
    }
}