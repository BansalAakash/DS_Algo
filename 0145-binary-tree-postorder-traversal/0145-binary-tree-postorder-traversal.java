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
    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<>();
        TreeNode cur = root;
        while(cur != null){
            if(cur.right == null){
                list.addFirst(cur.val);
                cur = cur.left;
            } else{
                TreeNode temp = cur.right;
                while(temp.left != null && temp.left != cur) temp = temp.left;
                if(temp.left == null){
                    list.addFirst(cur.val);
                    temp.left = cur;
                    cur = cur.right;
                } else{
                    temp.left = null;
                    cur = cur.left;
                }
            }
        }
        return list;
    }
}