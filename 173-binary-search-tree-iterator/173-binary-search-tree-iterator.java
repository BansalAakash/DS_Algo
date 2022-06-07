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
class BSTIterator {
    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        if(root != null) {
            stack.push(root);
            TreeNode temp = root;
            while(temp.left != null) {
                stack.push(temp.left);
                temp = temp.left;
            }
        }
    }
    
    public int next() {
        TreeNode temp = stack.pop();
        int result = temp.val;
        if(temp.right != null) {
            stack.push(temp.right);
            temp = temp.right;
            while(temp.left != null){
                stack.push(temp.left);
                temp = temp.left;
            }
        }
        return result;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */