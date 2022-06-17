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
        List<Integer> list = new LinkedList<>();
        if(root == null)
            return list;
        Deque<TreeNode> dq = new ArrayDeque<>();
        dq.add(root);
        while(!dq.isEmpty()){
            int size = dq.size();
            list.add(dq.getLast().val);
            while(size-- > 0){
                TreeNode temp = dq.poll();
                if(temp.left != null)
                    dq.add(temp.left);
                if(temp.right != null)
                    dq.add(temp.right);
            }
        }
        return list;
    }
}