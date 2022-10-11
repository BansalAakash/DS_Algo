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
        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        HashSet<TreeNode> visited = new HashSet<>();
        TreeNode temp = root, temp1;
        while(temp != null){
            stack.push(temp);
            temp = temp.left;
        }
        while(!stack.isEmpty()){
            temp = stack.peek();
            if(temp.right == null || visited.contains(temp.right)){
                result.add(temp.val);
                stack.pop();
            }
            else {
                temp1 = temp.right;
                while(temp1 != null){
                    stack.push(temp1);
                    visited.add(temp1);
                    temp1 = temp1.left;
                }
            }
        }
        
        return result;
    }
}