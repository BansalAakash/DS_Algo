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
    TreeNode helper(HashMap<Integer, Integer> in, int[] post, int left, int right){
        if(left > right)
            return null;
        int rootVal = post[index--];
        TreeNode root = new TreeNode(rootVal);
        root.right = helper(in, post, in.get(rootVal) + 1, right);
        root.left = helper(in, post, left, in.get(rootVal) - 1);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = inorder.length;
        if(n == 0)
            return null;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0;i < n;i++)
            map.put(inorder[i], i);
        index = n - 1;
        return helper(map, postorder, 0, n - 1);
    }
}