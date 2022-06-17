class Solution {
    int[] dir = {0, 1, 0, -1, 0};       //right, down, left, up
    int m, n;
    boolean visited[][];
    char[][] grid;
    int mark(int i, int j){
        if(i < 0 || j < 0 || i == m || j == n || visited[i][j] || grid[i][j] == '0')
            return 0;
        visited[i][j] = true;
        for(int k = 0;k < 4;k++)
            mark(i + dir[k], j + dir[k + 1]);
        return 1;
    }
    public int numIslands(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        visited = new boolean[m][n];
        this.grid = grid;
        for(boolean[] row : visited)
            Arrays.fill(row, false);
        
        int count = 0;
        for(int i = 0;i < m;i++)
            for(int j = 0;j < n;j++)
                count += mark(i, j);
        
        return count;
    }
}