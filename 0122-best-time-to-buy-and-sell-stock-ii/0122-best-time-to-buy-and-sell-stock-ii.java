class Solution {
    int f(int i, int[] prices, int n, int canBuy, int[][] dp){
        //canBuy = 1 ; can buy, 0 ; cannot buy
        if(i == n)
            return 0;
        
        if(dp[canBuy][i] != -1)
            return dp[canBuy][i];
        int profit = 0;
        if(canBuy == 1)
            profit = Math.max(f(i + 1, prices, n, 0, dp) - prices[i], f(i + 1, prices, n, 1, dp));
        else
            profit = Math.max(f(i + 1, prices, n, 1, dp) + prices[i], f(i + 1, prices, n, 0, dp));
        return dp[canBuy][i] = profit;
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[2][n];
        Arrays.fill(dp[0], -1);
        Arrays.fill(dp[1], -1);
        return f(0, prices, n, 1, dp);
    }
}