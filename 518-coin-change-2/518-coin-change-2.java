class Solution {
    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;                   //There is always 1 way of making amount 0 with any coins
        for(int i = 1;i <= coins.length;i++)
            for(int j = 1;j <= amount;j++)
                if(j >= coins[i - 1])
                    dp[j] += dp[j - coins[i - 1]];
        return dp[amount];
    }
}