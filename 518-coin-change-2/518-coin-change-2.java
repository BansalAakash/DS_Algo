class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n + 1][amount + 1];
        Arrays.sort(coins);
        dp[0][0] = 1;                       //1 way of making amount 0 without coins
        for(int i = 1;i <= n;i++){
            dp[i][0] = 1;                   //There is always 1 way of making amount 0 with any coins
            for(int j = 1;j <= amount;j++){
                dp[i][j] = dp[i - 1][j];
                if(j >= coins[i - 1])
                    dp[i][j] += dp[i][j - coins[i - 1]];        //take the coin
            }
        }
        return dp[n][amount];
    }
}