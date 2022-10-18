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
    int modCount = 0, curVal = 0, curCount = 0, maxCount = 0;
    int[] mods;
    void helper(int val){
        if(curVal != val){
            curCount = 0;
            curVal = val;
        }
        curCount++;
        if(curCount > maxCount){
            maxCount = curCount;
            modCount = 1;
        } else if(curCount == maxCount){
            if(mods != null)
                mods[modCount] = val;
            modCount++;
        }
    }

    void morris(TreeNode root) {
        TreeNode cur = root, node = null;
        while (cur != null) {
            if (cur.left != null) {
                node = cur.left;
                while (node.right != null && node.right != cur) node = node.right;
                if (node.right == null) {
                    node.right = cur;
                    cur = cur.left;
                } else {
                    node.right = null;
                    helper(cur.val);
                    cur = cur.right;
                }
            } else {
                helper(cur.val);
                cur = cur.right;
            }
        }
    }

    public int[] findMode(TreeNode root) {
        morris(root);
        mods = new int[modCount];
        modCount = 0;
        curCount = 0;
        morris(root);
        return mods;
    }
}
