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
    TreeNode solve(int[] pre, HashMap<Integer, Integer> map, int low, int high){
        if(low > high)
            return null;
        int rootVal = pre[index++];
        TreeNode root = new TreeNode(rootVal);
        root.left = solve(pre, map, low, map.get(rootVal) - 1);
        root.right = solve(pre, map, map.get(rootVal) + 1, high);
        return root;
    }
    public TreeNode buildTree(int[] pre, int[] in) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0;i < in.length;i++)
            map.put(in[i], i);
        index = 0;
        return solve(pre, map, 0, in.length - 1);
    }
}