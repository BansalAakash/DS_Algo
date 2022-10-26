import java.util.*;
class Solution {
    boolean bfs(HashMap<Integer, ArrayList<Integer>> graph, int[] indegrees, int numCourses){
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0;i < numCourses;i++)
            if(indegrees[i] == 0)
                q.add(i);
        ArrayList<Integer> result = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.poll();
            result.add(node);
            for(int j : graph.get(node)){
                indegrees[j]--;
                if(indegrees[j] == 0)
                    q.add(j);
            }
        }
        return result.size() == numCourses;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        for(int i = 0;i < numCourses;i++)
            graph.put(i, new ArrayList<>());
        int[] indegrees = new int[numCourses];
        for(int[] row : prerequisites){
            graph.get(row[1]).add(row[0]);
            indegrees[row[0]]++;
        }
        return bfs(graph, indegrees, numCourses);
    }
}