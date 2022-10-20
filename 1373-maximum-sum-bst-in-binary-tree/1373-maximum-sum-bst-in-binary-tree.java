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
    public Node() {}
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
            return new Node(0, 0, 0, true);
        Node result = new Node(root.val, root.val, root.val, true), left = helper(root.left), right = helper(root.right);
        if(root.left != null){
            if(left.isBST && left.max < root.val){
                result.sum += left.sum;
                result.min = left.min;
            }
            else{
                result.isBST = false;
                result.sum = left.sum;
            }
        }
        if(root.right != null){
            if(result.isBST && right.isBST && right.min > root.val){
                result.sum += right.sum;
                result.max = right.max;
            }
            else{
                result.isBST = false;
                result.sum = Math.max(left.sum, right.sum);
            }
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