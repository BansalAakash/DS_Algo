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
        Stack<TreeNode> stack = new Stack<>();
        TreeNode temp = root;
        while(temp != null){
            result.add(temp.val);
            stack.push(temp);
            temp = temp.left;
        }
        while(!stack.isEmpty()){
            temp = stack.pop().right;
            while(temp != null){
                result.add(temp.val);
                stack.push(temp);
                temp = temp.left;
            }
        }
        return result;
    }
}