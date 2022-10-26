class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        HashMap<Integer, ArrayList<Integer>> graph = new HashMap<>();
        for(int i = 0;i < numCourses;i++)
            graph.put(i, new ArrayList<>());
        int[] indegrees = new int[numCourses];
        for(int[] row : prerequisites){
            graph.get(row[1]).add(row[0]);
            indegrees[row[0]]++;
        }
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
        if(result.size() < numCourses)
            return new int[] {};
        int[] arr = new int[result.size()];
        for(int i = 0;i < numCourses;i++)
            arr[i] = result.get(i);
        return arr;
    }
}