class Solution {
    private static final int[] dirs = {-1, 0, 1, 0, -1};
    void bfs(int row, int col, char[][] grid, int m, int n){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{row, col});
        grid[row][col] = '0';
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int i = cur[0], j = cur[1];
            for(int k = 0;k < 4;k++){
                int r = i + dirs[k], c = j + dirs[k + 1];
                if(r >= 0 && c >= 0 && r < m && c < n && grid[r][c] == '1'){
                    q.add(new int[] {r, c});
                    grid[r][c] = '0';
                }
            }
        }
    }
    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length, result = 0;
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(grid[i][j] == '1'){
                    bfs(i, j, grid, m, n);
                    result++;
                }
            }
        }
        return result;
    }
}