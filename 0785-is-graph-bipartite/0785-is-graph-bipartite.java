import java.util.*;
class Solution {
    public boolean isBipartite(int[][] graph) {
        Queue<Integer> q = new LinkedList<>();
        int n = graph.length;
        int[] color = new int[n];           //0 means unvisited, 1 means color 1, 2 means color 2
        for(int l = 0;l < n;l++){
            if(color[l] != 0)
                continue;
            q.add(l);
            color[l] = 1;
            while(!q.isEmpty()){
                int i = q.poll();
                for(int j : graph[i]){
                    if(color[j] == 0){
                        color[j] = color[i] == 1 ? 2 : 1;
                        q.add(j);
                    }
                    else if(color[j] == color[i])
                        return false;
                }
            }
        }
        return true;
    }
}