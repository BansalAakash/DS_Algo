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
    
    //just like Kadane's
    int[] helper(TreeNode root){
        if(root == null)
            return new int[]{0, Integer.MIN_VALUE};
        if(root.left == null && root.right == null)
            return new int[]{root.val, root.val};
        int[] left = helper(root.left);
        int[] right = helper(root.right);
        int left_ = Math.max(0, left[0]);                           //root + left Path sum or 0 if left path sum is negative
        int right_ = Math.max(0, right[0]);                         //root + right path sum or 0 if right path sum is negative
        int maxPath = root.val + Math.max(left_, right_);       
        int max = Math.max(left_ + right_ + root.val, Math.max(left[1], right[1]));   //Max of a. path possing through cur node, b. left max, c. right max
        return new int[] {maxPath, max};
    }
    public int maxPathSum(TreeNode root) {
        return helper(root)[1];
    }
}