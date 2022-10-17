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
    int index;
    TreeNode helper(int[] A, int bound){
        if(index == A.length || A[index] > bound)
            return null;
        TreeNode root = new TreeNode(A[index++]);
        root.left = helper(A, root.val);
        root.right = helper(A, bound);
        return root;
    }
    public TreeNode bstFromPreorder(int[] a) {
        index = 0;
        return helper(a, Integer.MAX_VALUE);
    }
}