class Codec {

    // Encodes a tree to a single string.
    private void serializeHelper(TreeNode root, StringBuilder str){
    	if(root == null){
    		str.append("#,");
    		return;
    	}
    	str.append(root.val).append(",");
    	serializeHelper(root.left, str);
    	serializeHelper(root.right, str);
    }
    public String serialize(TreeNode root) {
        StringBuilder str = new StringBuilder();
        if(root != null)
        	serializeHelper(root, str);
        return str.toString();
    }

    private TreeNode deserializeHelper(Queue<String> q){
    	if(q.isEmpty())
    		return null;
    	String str = q.poll();
    	if(str.equals("#"))
    		return null;
    	TreeNode root = new TreeNode(Integer.parseInt(str));
    	root.left = deserializeHelper(q);
    	root.right = deserializeHelper(q);
    	return root;
    }
    public TreeNode deserialize(String data) {
        return data.equals("") ? null : deserializeHelper(new LinkedList<>(Arrays.asList(data.split(","))));
    }
}