import java.util.*;
class Solution {
    boolean dfs(int src, int cur_color, int[] color, int[][] graph){
        color[src] = cur_color;
        int next_color = cur_color == 1 ? 2 : 1;
        for(int j : graph[src]){
            if(color[j] == color[src])
                return false;
            else if(color[j] == 0)
                if(!dfs(j, next_color, color, graph))
                    return false;
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];           //0 - unvisited, 1/2 - color 1/2
        for(int i = 0;i < n;i++){
            if(color[i] != 0)
                continue;
            if(!dfs(i, 1, color, graph))
                return false;
        }
        return true;
    }
}