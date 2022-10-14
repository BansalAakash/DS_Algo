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
    int[] helper(TreeNode root){
        if(root == null)
            return new int[]{0, 0};
        int[] left = helper(root.left), right = helper(root.right);
        int pass_through = left[0] + right[0];
        int max = Math.max(left[0] + right[0], Math.max(left[1], right[1]));
        return new int[]{Math.max(left[0], right[0]) + 1, max};
    }
    public int diameterOfBinaryTree(TreeNode root) {
        int[] result = helper(root);
        return result[1];
    }
}