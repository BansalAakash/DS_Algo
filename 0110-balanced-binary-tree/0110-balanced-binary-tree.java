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
    int helper(TreeNode root){
        if(root == null)
            return 0;
        int left = helper(root.left), right = helper(root.right);
        if(left == Integer.MAX_VALUE || right == Integer.MAX_VALUE || Math.abs(left - right) > 1)
            return Integer.MAX_VALUE;
        return Math.max(left, right) + 1;
    }
    public boolean isBalanced(TreeNode root) {
        return helper(root) != Integer.MAX_VALUE;
    }
}