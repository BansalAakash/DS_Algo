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
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root, result = null;
        while(temp != null){
            stack.push(temp);
            temp = temp.left;
        }
        while(k-- > 0){
            result = stack.pop();
            if(result.right != null){
                temp = result.right;
                while(temp != null){
                    stack.push(temp);
                    temp = temp.left;
                }
            }
        }
        return result.val;
    }
}









