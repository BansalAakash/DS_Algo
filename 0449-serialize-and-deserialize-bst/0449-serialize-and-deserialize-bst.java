class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
    	StringBuilder str = new StringBuilder();
    	Stack<TreeNode> stack = new Stack<>();
    	if(root != null)
    		stack.push(root);
    	while(!stack.isEmpty()){
    		TreeNode node = stack.pop();
    		if(node.right != null)
    			stack.push(node.right);
    		if(node.left != null)
    			stack.push(node.left);
    		str.append(node.val).append(",");
    	}
    	return str.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
    	if(data.equals(""))
    		return null;
    	String[] arr = data.split(",");
        Stack<TreeNode> stack = new Stack<>();
        int index = 0;
        TreeNode root = new TreeNode(Integer.parseInt(arr[index++]));
        stack.push(root);
        while(index < arr.length){
        	TreeNode cur = new TreeNode(Integer.parseInt(arr[index++]));
        	TreeNode node = stack.peek();
        	while(!stack.isEmpty() && cur.val > stack.peek().val)
        		node = stack.pop();
        	if(cur.val < node.val)
        		node.left = cur;
        	else node.right = cur;
        	stack.push(cur);
        }
        return root;
    }
}