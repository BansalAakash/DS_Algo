/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder str = new StringBuilder();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int flag = 1;
        while(!q.isEmpty() && flag == 1){
            int size = q.size();
            flag = 0;
            while(size-- > 0){
                TreeNode temp = q.poll();
                if(temp == null){
                    str.append("null,");
                }
                else {
                    str.append(temp.val + ",");
                    q.add(temp.left);
                    q.add(temp.right);
                    if(temp.left != null || temp.right != null)
                        flag = 1;
                }
            }
        }
        str.setLength(str.length() - 1);
        // System.out.println(str.toString());
        return str.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] input = data.split(",");
        int n = input.length, cur = 0;
        TreeNode[] t = new TreeNode[n];
        for(int i = 0;i < n;i++)
            t[i] = input[i].equals("null") ? null : new TreeNode(Integer.parseInt(input[i]));
        for(int i = 0;i < n;i++){
            if(t[i] == null)
                continue;
            int leftChild = 2 * cur + 1;
            int rightChild = 2 * cur + 2;
            t[i].left = leftChild < n ? t[leftChild] : null;
            t[i].right = rightChild < n ? t[rightChild] : null;
            cur++;
        }
        return t[0];
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));