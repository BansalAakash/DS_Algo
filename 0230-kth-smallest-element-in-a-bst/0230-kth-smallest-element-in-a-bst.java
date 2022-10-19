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
    public int kthSmallest(TreeNode root, int k) {
        TreeNode cur = root;
        while(cur != null){
            if(cur.left != null){
                TreeNode node = cur.left;
                while(node.right != null && node.right != cur)
                    node = node.right;
                if(node.right == null){
                    node.right = cur;
                    cur = cur.left;
                } else {
                    k--;
                    if(k == 0)
                        return cur.val;
                    node.right = null;
                    cur = cur.right;
                }
            } else {
                k--;
                if(k == 0)
                    return cur.val;
                cur = cur.right;
            }
        }
        return -1;
    }
}