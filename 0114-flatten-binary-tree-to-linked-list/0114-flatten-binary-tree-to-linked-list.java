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

    public void flatten(TreeNode root) {
        TreeNode cur = root;
        while (cur != null) {
            TreeNode node = cur.left;
            if (node != null) {
                while (node.right != null && node.right != cur) node = node.right;
                if (node.right == cur) {
                    node.right = cur.right;
                    cur.right = cur.left;
                    cur.left = null;
                    cur = node.right;
                } else {
                    node.right = cur;
                    if (cur.left != null) cur = cur.left;
                }
            } else cur = cur.right;
        }
    }
}
