class Solution {
    int f(int[] prices, int fee, int i, int n, int canBuy, int[][] dp){
        if(i == n)
            return 0;
        if(dp[canBuy][i] != -1)
            return dp[canBuy][i];
        int profit = 0;
        if(canBuy == 1){
            profit = Math.max(f(prices, fee, i + 1, n, 0, dp) - prices[i], f(prices, fee, i + 1, n, 1, dp));
        } else {
            profit = Math.max(f(prices, fee, i + 1, n, 1, dp) + prices[i] - fee, f(prices, fee, i + 1, n, 0, dp));
        }
        return dp[canBuy][i] = profit;
    }
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[2][n];
        for(int[] row : dp)
            Arrays.fill(row, -1);
        return f(prices, fee, 0, n, 1, dp);
    }
}