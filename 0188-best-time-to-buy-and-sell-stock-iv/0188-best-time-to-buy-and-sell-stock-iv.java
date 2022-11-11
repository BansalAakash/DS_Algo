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
        int[][][] dp = new int[2][k + 1][n];
        for(int[][] i : dp)
            for(int[] j : i)
                Arrays.fill(j, -1);
        return f(0, n, k, prices, 1, dp);
    }
}