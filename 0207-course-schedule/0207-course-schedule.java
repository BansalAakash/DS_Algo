import java.util.*;
class Solution {
    boolean dfs(int src, HashMap<Integer, ArrayList<Integer>> graph, int[] visited){
        if(visited[src] == 2)
            return true;
        if(visited[src] == 1)
            return false;
        visited[src] = 1;
        for(int i : graph.get(src)){
            if(!dfs(i, graph, visited))
                return false;
        }
        visited[src] = 2;
        return true;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        for(int i = 0;i < numCourses;i++)
            graph.put(i, new ArrayList<>());
        for(int[] row : prerequisites)
            graph.get(row[1]).add(row[0]);
        int[] visited = new int[numCourses];                // 0 means not visited, 1 means being visited, 2 means completed.
        for(int i = 0;i < numCourses;i++){
            if(!dfs(i, graph, visited))
                return false;
        }

        return true;
    }
}