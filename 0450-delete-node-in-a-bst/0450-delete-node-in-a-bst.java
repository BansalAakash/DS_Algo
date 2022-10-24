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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null)
            return null;
        if(root.val == key){
            if(root.left == null)
                return root.right;              //Inorder predecessor is null
            else{
                TreeNode temp = root.left, prev = null;
                while(temp.right != null){
                    prev = temp;
                    temp = temp.right;
                }
                
                if(prev != null){
                    prev.right = temp.left;
                    temp.left = root.left;
                }
                temp.right = root.right;
                return temp;
            }
        }
        else if(key < root.val)
            root.left = deleteNode(root.left, key);
        else
            root.right = deleteNode(root.right, key);
        return root;
    }
}