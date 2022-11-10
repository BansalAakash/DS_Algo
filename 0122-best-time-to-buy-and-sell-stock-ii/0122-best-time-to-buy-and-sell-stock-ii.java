class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[2][n + 1];
            for(int j = n - 1;j >= 0;j--){
                dp[1][j] = Math.max((dp[0][j + 1]) - prices[j], dp[1][j + 1]);
                dp[0][j] = Math.max((dp[1][j + 1]) + prices[j], dp[0][j + 1]);
            }
        return dp[1][0];
    }
}