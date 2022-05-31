class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        int n = coins.length;
        for(int i = 1;i <= amount;i++){
            for(int j = 0;j < n;j++){
                if(i >= coins[j] && dp[i - coins[j]] != -1){
                    if(dp[i] == 0) dp[i] = 1 + dp[i - coins[j]];
                    else dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
                }
            }
            if(dp[i] == 0) dp[i] = -1;
        }
        return dp[amount];
    }
}


//Doing this "-1" stuff because we have to return -1 if no combination found