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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        TreeNode cur = root;
        while(cur != null){
            if(cur.left == null){
                result.add(cur.val);
                cur = cur.right;
            }
            else{
                TreeNode temp = cur.left;
                while(temp.right != null && temp.right != cur) temp = temp.right;
                if(temp.right == cur){
                    temp.right = null;
                    cur = cur.right;
                } else{
                    result.add(cur.val);
                    temp.right = cur;
                    cur = cur.left;
                }
            }
        }
        return result;
    }
}