class Solution {
    public int minPathCost(int[][] grid, int[][] moveCost) {
        int minCost = Integer.MAX_VALUE, m = grid.length, n = grid[0].length;
        int[] dp = Arrays.copyOf(grid[0], n);
        for(int i = 1;i < m;i++){
            int[] temp = new int[n];
            for(int j = 0;j < n;j++){
                int min = Integer.MAX_VALUE;
                for(int k = 0;k < n;k++)
                    min = Math.min(min, moveCost[grid[i - 1][k]][j] + dp[k]);
                temp[j] += grid[i][j] + min;
            }
            dp = temp;
        }
        for(int i : dp)
            minCost = Math.min(i, minCost);
        return minCost;
    }
}