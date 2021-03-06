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
    void solve(TreeNode root, int val, List<List<Integer>> result, List<Integer> list){
        if(root == null)
            return;
        list.add(root.val);
        if(root.left == null && root.right == null && root.val == val)
            result.add(new ArrayList<>(list));
        else{
            solve(root.left, val - root.val, result, list);
            solve(root.right, val - root.val, result, list);
        }
        list.remove(list.size() - 1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        solve(root, targetSum, result, new ArrayList<>());
        return result;
    }
}