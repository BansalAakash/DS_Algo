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
    public boolean findTarget(TreeNode root, int k) {
        if(root == null)
            return false;
        Stack<TreeNode> maxStack = new Stack<>(), minStack = new Stack<>();
        TreeNode temp = root;
        while(temp != null){
        	minStack.push(temp);
        	temp = temp.left;
        }
        temp = root;
        while(temp != null){
        	maxStack.push(temp);
        	temp = temp.right;
        }
        TreeNode low = minStack.pop(), high = maxStack.pop();
        while(low != null && high != null && low.val < high.val){
        	int cur = low.val + high.val;
        	if(cur == k)
        		return true;
        	if(cur > k){
        		if(high.left != null){
        			temp = high.left;
        			while(temp != null){
        				maxStack.push(temp);
        				temp = temp.right;
        			}
        		}
        		high = maxStack.isEmpty() ? null : maxStack.pop();
        	} else {
        		if(low.right != null){
        			temp = low.right;
        			while(temp != null){
        				minStack.push(temp);
        				temp = temp.left;
        			}
        		}
        		low = minStack.isEmpty() ? null : minStack.pop();
        	}
        }
        return false;
    }
}