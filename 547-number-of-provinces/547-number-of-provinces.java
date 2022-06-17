class Solution {
    void dfs(int[][] A, boolean[] visited, int i){
        visited[i] = true;
        for(int j = 0;j < A.length;j++){
            if(A[i][j] == 1 && !visited[j])
                dfs(A, visited, j);
        }
    }
    public int findCircleNum(int[][] A) {
        int n = A.length, count = 0;
        boolean[] visited = new boolean[n];
        for(int i = 0;i < n;i++){
            if(!visited[i]){
                dfs(A, visited, i);
                count++;
            }
        }
        return count;
    }
}