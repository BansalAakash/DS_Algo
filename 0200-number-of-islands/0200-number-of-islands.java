class Solution {
    private static final int[] dirs = {-1, 0, 1, 0, -1};
    private boolean helper(char[][] grid, int[][] visited, int i, int j, int m, int n){
        if(i < 0 || j < 0 || i == m || j == n || visited[i][j] == 1 || grid[i][j] == '0')
            return false;
        visited[i][j] = 1;
        for(int i_ = 0; i_ < 4; i_++)
            helper(grid, visited, i + dirs[i_], j + dirs[i_ + 1], m, n);
        return true;
    }
    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length, result = 0;
        int[][] visited = new int[m][n];
        for(int i = 0;i < m;i++)
            for(int j = 0;j < n;j++)
                if(helper(grid, visited, i, j, m, n))
                    result++;
        return result;
    }
}