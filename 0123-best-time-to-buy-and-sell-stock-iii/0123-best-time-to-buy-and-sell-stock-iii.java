class Solution {
    int f(int i, int[] prices, int n, int cap, int canBuy, int[][][] dp){
        if(i == n || cap == 2)
            return 0;
        if(dp[canBuy][cap][i] != -1)
            return dp[canBuy][cap][i];
        int profit = 0;
        if(canBuy == 1)
            profit = Math.max(f(i + 1, prices, n, cap, 0, dp) - prices[i], f(i + 1, prices, n, cap, 1, dp));
        else profit = Math.max(f(i + 1, prices, n, cap + 1, 1, dp) + prices[i], f(i + 1, prices, n, cap, 0, dp));
        return dp[canBuy][cap][i] = profit;
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[2][3][n + 1];
        for(int[][] i : dp)
            for(int j[] : i)
                Arrays.fill(j, -1);
        return f(0, prices, n, 0, 1, dp);
    }
}