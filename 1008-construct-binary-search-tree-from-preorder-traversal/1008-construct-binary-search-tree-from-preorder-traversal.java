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
    TreeNode helper(int[] A, int[] index, int bound){
        if(index[0] == A.length || A[index[0]] > bound)
            return null;
        TreeNode root = new TreeNode(A[index[0]++]);
        root.left = helper(A, index, root.val);
        root.right = helper(A, index, bound);
        return root;
    }
    public TreeNode bstFromPreorder(int[] a) {
        return helper(a, new int[1], Integer.MAX_VALUE);
    }
}