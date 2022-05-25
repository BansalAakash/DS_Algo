class Solution {
    int[][] cumulativeArray(int[][] A){
        int m = A.length, n = A[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for(int i = 1;i <= m;i++)
            for(int j = 1;j <= n;j++)
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1] + A[i - 1][j - 1] - dp[i - 1][j - 1];
        return dp;
    }
    int rangeQuery(int[][] dp, int row1, int col1, int row2, int col2){
        return dp[row2 + 1][col2 + 1] - dp[row1][col2 + 1] - dp[row2 + 1][col1] + dp[row1][col1];
    }
    public int[][] matrixBlockSum(int[][] A, int k) {
        int[][] dp = cumulativeArray(A);
        int m = A.length, n = A[0].length;
        int[][] ans = new int[m][n];
        for(int i = 0;i < m;i++)
            for(int j = 0;j < n;j++)
                ans[i][j] = rangeQuery(dp, Math.max(0, i - k), Math.max(0, j - k), Math.min(m - 1, i + k), Math.min(n - 1, j + k));
        return ans;
    }
}