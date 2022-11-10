class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[2][3][n + 1];
        
        for(int cap = 1;cap >= 0;cap--){
            for(int i = n - 1;i >= 0;i--){
                dp[1][cap][i] = Math.max(dp[0][cap][i + 1] - prices[i], dp[1][cap][i + 1]);
                dp[0][cap][i] = Math.max(dp[1][cap + 1][i + 1] + prices[i], dp[0][cap][i + 1]);
            }
        }
        return dp[1][0][0];
    }
}