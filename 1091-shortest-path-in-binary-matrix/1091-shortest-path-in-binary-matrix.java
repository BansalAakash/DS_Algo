class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[] dirs = {-1, -1, 0, 1, 1, 0, -1, 1, -1};
        if(grid[0][0] == 1 || grid[m - 1][n - 1] == 1)
            return -1;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0, 0});
        int cost = 1;
        grid[0][0] = 1;
        //will update grid to 1 instead of using boolean visited
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                int[] cur = q.poll();
                int i = cur[0], j = cur[1];
                if(i == m - 1 && j == n - 1)
                    return cost;
                for(int k = 0;k < 8;k++){
                    if(i + dirs[k] >= 0 && j + dirs[k + 1] >= 0 && i + dirs[k] < m && j + dirs[k + 1] < n && grid[i + dirs[k]][j + dirs[k + 1]] == 0){
                        q.add(new int[] {i + dirs[k], j + dirs[k + 1]});
                        grid[i + dirs[k]][j + dirs[k + 1]] = 1;
                    }
                }
            }
            cost++;
        }
        return -1;
    }
}