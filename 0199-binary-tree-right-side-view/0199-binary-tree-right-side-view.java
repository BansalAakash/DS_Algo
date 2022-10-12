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
    public List<Integer> rightSideView(TreeNode root) {
        LinkedList<TreeNode> list = new LinkedList<>();
        List<Integer> result = new ArrayList<>();
        if(root == null)
            return result;
        list.add(root);
        while(!list.isEmpty()){
            result.add(list.getLast().val);
            int s = list.size();
            while(s-- > 0){
                TreeNode temp = list.removeFirst();
                if(temp.left != null) list.addLast(temp.left);
                if(temp.right != null) list.addLast(temp.right);
            }
        }
        return result;
    }
}