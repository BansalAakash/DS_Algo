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
    int helper(TreeNode root, HashMap<Integer, Integer> map){
        if(root == null)
            return 0;
        int val = map.getOrDefault(root.val, 0);
        map.put(root.val, val + 1);
        int left = helper(root.left, map);
        int right = helper(root.right, map);
        return Math.max(val + 1, Math.max(left, right));
    }
    public int[] findMode(TreeNode root) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int max = helper(root, map);
        List<Integer> list = new ArrayList<>();
        for(int i : map.keySet())
            if(map.get(i) == max)
                list.add(i);
        int[] result = new int[list.size()];
        for(int i = 0; i < list.size();i++)
            result[i] = list.get(i);
        return result;
    }
}