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
    TreeNode helper(int[] pre, HashMap<Integer, Integer> in, int left, int right){
        if(left > right)
            return null;
        TreeNode root = new TreeNode(pre[left]);
        int r = left + 1;
        while(r <= right && in.get(pre[r]) < in.get(pre[left])) r++;
        r--;
        root.left = helper(pre, in, left + 1, r);
        root.right = helper(pre, in, r + 1, right);
        return root;
    }
    public TreeNode buildTree(int[] pre, int[] in) {
        int n = pre.length;if(n == 0)
            return null;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0;i < n;i++)
            map.put(in[i], i);
        return helper(pre, map, 0, n - 1);
    }
}