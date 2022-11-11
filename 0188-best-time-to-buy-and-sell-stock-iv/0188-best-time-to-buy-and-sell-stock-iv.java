class Solution {
    // int f(int i, int n, int k, int[] prices, int canBuy, int[][][] dp){
    //     if(i == n || k == 0)
    //         return 0;
    //     if(dp[canBuy][k][i] != -1)
    //         return dp[canBuy][k][i];
    //     int profit = 0;
    //     if(canBuy == 1)
    //         profit = Math.max(f(i + 1, n, k, prices, 0, dp) - prices[i], f(i + 1, n, k, prices, 1, dp));
    //     else
    //         profit = Math.max(f(i + 1, n, k - 1, prices, 1, dp) + prices[i], f(i + 1, n, k, prices, 0, dp));
    //     return dp[canBuy][k][i] = profit;
    // }
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        k *= 2;
        int[] ahead = new int[k + 1];
        for(int i = n - 1;i >= 0;i--){
            int[] cur = new int[k + 1];
            for(int j = k - 1; j >= 0;j--){
                if(j % 2 == 0)
                    cur[j] = Math.max(ahead[j + 1] - prices[i], ahead[j]);
                else
                    cur[j] = Math.max(ahead[j + 1] + prices[i], ahead[j]);
            }
            ahead = cur;
        }
        return ahead[0];
    }
}