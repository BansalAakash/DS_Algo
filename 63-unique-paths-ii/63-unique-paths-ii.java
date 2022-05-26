class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        if(obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) return 0;
        int[] dp = new int[n];
        int i = 0;
        while(i < n && obstacleGrid[0][i] == 0) dp[i++] = 1;
        while(i < n) dp[i++] = 0;
        for(i = 1;i < m;i++){
            int[] temp = new int[n];
            temp[0] = obstacleGrid[i][0] == 0 ? dp[0] : 0;
            for(int j = 1;j < n;j++){
                if(obstacleGrid[i][j] == 1) temp[j] = 0;
                else temp[j] = temp[j - 1] + dp[j];
            }
            dp = temp;
        }
        return dp[n - 1];
    }
}