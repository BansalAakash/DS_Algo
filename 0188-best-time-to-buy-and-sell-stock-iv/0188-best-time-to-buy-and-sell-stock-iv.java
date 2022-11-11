class Solution {
    int f(int i, int n, int k, int[] prices, int canBuy, int[][][] dp){
        if(i == n || k == 0)
            return 0;
        if(dp[canBuy][k][i] != -1)
            return dp[canBuy][k][i];
        int profit = 0;
        if(canBuy == 1)
            profit = Math.max(f(i + 1, n, k, prices, 0, dp) - prices[i], f(i + 1, n, k, prices, 1, dp));
        else
            profit = Math.max(f(i + 1, n, k - 1, prices, 1, dp) + prices[i], f(i + 1, n, k, prices, 0, dp));
        return dp[canBuy][k][i] = profit;
    }
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[2][k + 1][n + 1];
        for(int j = k - 1; j >= 0;j--){
            for(int i = n - 1;i >= 0;i--){
                dp[1][j][i] = Math.max(dp[0][j][i + 1] - prices[i], dp[1][j][i + 1]);
                dp[0][j][i] = Math.max(dp[1][j + 1][i + 1] + prices[i], dp[0][j][i + 1]);
            }
        }
        return dp[1][0][0];
    }
}