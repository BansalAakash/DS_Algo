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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)
            return result;
        Stack<TreeNode> l2r = new Stack<>();
        Stack<TreeNode> r2l = new Stack<>();
        l2r.push(root);
        int size = 1;
        List<Integer> list = new ArrayList<>();
        while(!l2r.isEmpty() || !r2l.isEmpty()){
            List<Integer> list1 = new ArrayList<>();
            while(!l2r.isEmpty()){
                TreeNode temp = l2r.pop();
                list1.add(temp.val);
                if(temp.left != null)
                    r2l.push(temp.left);
                if(temp.right != null)
                    r2l.push(temp.right);
            }
            result.add(list1);
            if(!r2l.isEmpty()){
                List<Integer> list2 = new ArrayList<>();
                while(!r2l.isEmpty()){
                    TreeNode temp = r2l.pop();
                    list2.add(temp.val);
                    if(temp.right != null)
                        l2r.push(temp.right);
                    if(temp.left != null)
                        l2r.push(temp.left);
                }
                result.add(list2);
            }
        }
        return result;
    }
}