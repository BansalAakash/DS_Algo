class Solution {
    int helper(int[][] grid, int r, int c){
        if(r < 0 ||r >= grid.length || c < 0 || c >= grid[0].length || grid[r][c] != 1) return 0;
        grid[r][c] = -1;
        return 1 + helper(grid, r - 1, c)
                 + helper(grid, r + 1, c)
                 + helper(grid, r, c - 1)
                 + helper(grid, r, c + 1);
    }
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for(int i = 0;i < grid.length;i++)
            for(int j = 0;j < grid[0].length;j++)
                maxArea = Math.max(maxArea, helper(grid, i, j));
        return maxArea;
    }
}