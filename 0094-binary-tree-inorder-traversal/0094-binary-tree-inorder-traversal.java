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
    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        List<Integer> result = new ArrayList<>();
        while(temp != null){
            stack.push(temp);
            temp = temp.left;
        }
        while(!stack.isEmpty()){
            temp = stack.pop();
            result.add(temp.val);
            temp = temp.right;
            while(temp != null){
                stack.push(temp);
                temp = temp.left;
            }
        }
        return result;
    }
}