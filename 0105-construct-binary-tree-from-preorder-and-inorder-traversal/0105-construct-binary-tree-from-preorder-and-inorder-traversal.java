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
    int index;
    TreeNode helper(int[]pre_, HashMap<Integer, Integer> in, int left, int right){
        if(left > right)
            return null;
        int rootVal = pre_[index];
        TreeNode root = new TreeNode(rootVal);
        index++;
        root.left = helper(pre_, in, left, in.get(rootVal) - 1);
        root.right = helper(pre_, in, in.get(rootVal) + 1, right);
        return root;
    }
    public TreeNode buildTree(int[] pre, int[] in) {
        int n = pre.length;
        index = 0;
        if(n == 0)
            return null;
        HashMap<Integer, Integer> in_map = new HashMap<>();
        for(int i = 0;i < n;i++)
            in_map.put(in[i], i);
        return helper(pre, in_map, 0, n - 1);
    }
}