class Solution {
    int mark(char[][] grid, boolean[][] visited, int i, int j, int m, int n){
        if(i < 0 || j < 0 || i == m || j == n || visited[i][j] || grid[i][j] == '0')
            return 0;
        visited[i][j] = true;
        mark(grid, visited, i + 1, j, m, n);
        mark(grid, visited, i - 1, j, m, n);
        mark(grid, visited, i, j + 1, m, n);
        mark(grid, visited, i, j - 1, m, n);
        return 1;
    }
    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length, count = 0;
        boolean visited[][] = new boolean[m][n];
        for(boolean[] row : visited)
            Arrays.fill(row, false);
        for(int i = 0;i < m;i++)
            for(int j = 0;j < n;j++)
                count += mark(grid, visited, i, j, m, n);
        return count;
    }
}