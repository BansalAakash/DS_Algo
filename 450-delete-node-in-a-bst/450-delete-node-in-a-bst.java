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
    TreeNode helper(TreeNode root){
        if(root.left == null && root.right == null)
            return null;
        TreeNode parent = root;
        if(root.left != null){
            TreeNode temp = root.left;
            if(temp.right == null)
                parent.left = temp.left;
            else{
                while(temp.right != null){
                    parent = temp;
                    temp = temp.right;
                }
                parent.right = temp.left;
            }
            return temp;
        } else {
            TreeNode temp = root.right;
            if(temp.left == null)
                parent.right = temp.right;
            else{
                while(temp.left != null){
                    parent = temp;
                    temp = temp.left;
                }
                parent.left = temp.right;
            }
            return temp;
        }
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null)
            return root;
        if(root.val == key){
            TreeNode temp = helper(root);
            if(temp == null) 
                return null;
            temp.left = root.left;
            temp.right = root.right;
            return temp;
        } else if(key < root.val)
            root.left = deleteNode(root.left, key);
        else root.right = deleteNode(root.right, key);
        return root;
    }
}