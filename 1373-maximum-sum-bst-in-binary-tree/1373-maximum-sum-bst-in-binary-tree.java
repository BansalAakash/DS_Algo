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
class Node {
    int sum, min, max;
    boolean isBST;
    public Node() {
        this.sum = 0;
        this.min = Integer.MAX_VALUE;
        this.max = Integer.MIN_VALUE;
        this.isBST = true;
    }
    public Node(int sum, int min, int max, boolean isBST) {
        this.sum = sum;
        this.min = min;
        this.max = max;
        this.isBST = isBST;
    }
}
class Solution {
    int globalMax;
    private Node helper(TreeNode root){
        if(root == null)
            return new Node();
        Node result = new Node(root.val, root.val, root.val, true), left = helper(root.left), right = helper(root.right);
        if((root.left != null && root.val <= left.max) || (root.right != null && root.val >= right.min) || !left.isBST || !right.isBST){
            result.isBST = false;
            result.sum = Math.max(left.sum, right.sum);
        } else {
            result.sum += left.sum + right.sum;
            result.min = Math.min(root.val, left.min);
            result.max = Math.max(root.val, right.max);
        }
        globalMax = Math.max(globalMax, result.sum);
        return result;
    }
    public int maxSumBST(TreeNode root) {
        globalMax = 0;
        helper(root);
        return globalMax;
    }
}