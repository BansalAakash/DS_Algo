// class TreeNode{
//     public int informTime;
//     public List<TreeNode> children;
//     public TreeNode(int informTime){
//         this.informTime = informTime;
//         this.children = new ArrayList<>();
//     }
// }

class Solution {
    // TreeNode formTree(int headID, int[] manager, int[] informTime, int n){
    //     TreeNode root = new TreeNode(informTime[headID]);
    //     for(int i = 0;i < n;i++){
    //         if(manager[i] == headID){
    //             root.children.add(formTree(i, manager, informTime, n));
    //         }
    //     }
    //     return root;
    // }
    int dfs(int n, int headID, HashMap<Integer, List<Integer>> map, int[] informTime){
        if(!map.containsKey(headID)) return 0;
        int result = 0;
        for(int i : map.get(headID)){
            result = Math.max(result, dfs(n, i, map, informTime));
        }
        return result + informTime[headID];
        
    }
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0;i < n;i++){
            map.putIfAbsent(manager[i], new ArrayList<Integer>());
            map.get(manager[i]).add(i);
        }
        return dfs(n, headID, map, informTime);
    }
}