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
    int[] helper(TreeNode root){
        if(root == null)
            return new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE};
        if(root.left == null && root.right == null)
            return new int[]{root.val, root.val};
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        int left_ = root.val + Math.max(0, left[0]);                //root + left Path sum or 0 if left path sum is negative
        int right_ = root.val + Math.max(0, right[0]);              //root + right path sum or 0 if right path sum is negative
        int maxPath = Math.max(left_, right_);
        int max2 = Math.max(left[1], right[1]);                     //left[1] and right[1] store the max received from either side
        int max3 = Math.max(0, left[0]) + root.val + Math.max(0, right[0]);
        int max = Math.max(maxPath, Math.max(max2, max3));
        return new int[] {maxPath, max};
    }
    public int maxPathSum(TreeNode root) {
        return helper(root)[1];
    }
}