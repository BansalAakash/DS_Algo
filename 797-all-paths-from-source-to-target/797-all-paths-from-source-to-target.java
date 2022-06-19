class Solution {
    void bfs(int[][] graph, List<List<Integer>> result, List<Integer> list, int i){
        list.add(i);
        if(i == graph.length - 1){
            result.add(new ArrayList<>(list));
            list.remove(list.size() - 1);
            return;
        }
        for(int j : graph[i])
            bfs(graph, result, list, j);
        list.remove(list.size() - 1);
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        bfs(graph, result, new ArrayList<>(), 0);
        return result;
    }
}