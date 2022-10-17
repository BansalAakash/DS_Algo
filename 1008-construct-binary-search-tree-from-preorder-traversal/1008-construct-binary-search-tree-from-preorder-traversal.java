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
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = null;
        for(int i : preorder){
            if(root == null)
                root = new TreeNode(i);
            else{
                TreeNode temp = root;
                while(true){
                    if(temp.val > i){
                        if(temp.left == null){
                            temp.left = new TreeNode(i);
                            break;
                        }
                        else temp = temp.left;
                    } else {
                        if(temp.right == null){
                            temp.right = new TreeNode(i);
                            break;
                        }
                        else temp = temp.right;
                    }
                }
            }
        }
        return root;
    }
}