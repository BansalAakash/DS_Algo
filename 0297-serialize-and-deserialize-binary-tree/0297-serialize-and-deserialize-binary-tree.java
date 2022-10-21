class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder str = new StringBuilder();
        if(root == null)
        	return str.toString();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        str.append(root.val);
        str.append(",");
        int deleteIndex = str.length() - 1;
        while(!q.isEmpty()){
        	TreeNode node = q.poll();
        	if(node.left != null){
        		str.append(node.left.val + ",");
        		deleteIndex = str.length() - 1;
        		q.add(node.left);
        	}
        	else str.append("null,");
        	if(node.right != null){
        		str.append(node.right.val + ",");
        		deleteIndex = str.length() - 1;
        		q.add(node.right);
        	}
        	else str.append("null,");
        }
        str.delete(deleteIndex, str.length());
        return str.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        if(arr.length == 0 || data.equals(""))
        	return null;
        int n = arr.length;
        TreeNode[] nodes = new TreeNode[n];
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));
        nodes[0] = root;
        int index = 1;
        for(int i = 0;i < n;i++){
        	if(nodes[i] != null && index < n){
        		if(!arr[index].equals("null")){
	        		nodes[i].left = new TreeNode(Integer.parseInt(arr[index]));
	        		nodes[index] = nodes[i].left;
        		}
        		index++;
        	}
        	if(nodes[i] != null && index < n){
        		if(!arr[index].equals("null")){
	        		nodes[i].right = new TreeNode(Integer.parseInt(arr[index]));
	        		nodes[index] = nodes[i].right;
        		}
        		index++;
        	}
        }
        return root;
    }
}