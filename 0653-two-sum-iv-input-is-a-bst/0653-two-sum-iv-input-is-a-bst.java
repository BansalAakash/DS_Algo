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
    TreeNode find(TreeNode root, int val) {
        if(root == null || val == root.val)
            return root;
        if(val < root.val)
            return find(root.left, val);
        return find(root.right, val);
    }
    public boolean findTarget(TreeNode root, int k) {
        if(root == null)
            return false;
        TreeNode cur = root;
        Stack<TreeNode> stack = new Stack<>();
        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            TreeNode find_ = find(root, k - cur.val);
            if(find_ != null && find_ != cur)
                return true;
            cur = cur.right;
        }
        return false;
    }
}