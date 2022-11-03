class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0)
            return 0;
        int[] dp = new int[amount + 1];
        int n = coins.length, count = 1;
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 0;i < n;i++)
            for(int j = 1;j <= amount;j++)
                if(j >= coins[i] && dp[j - coins[i]] != Integer.MAX_VALUE)
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}