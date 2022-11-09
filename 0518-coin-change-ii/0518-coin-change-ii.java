class Solution {
    public int change(int a, int[] coins) {
        int[] dp = new int[a + 1];
        dp[0] = 1;
        for(int i = 1;i <= coins.length;i++)
            for(int j = coins[i - 1];j <= a;j++)
                dp[j] += dp[j - coins[i - 1]];
        return dp[a];
    }
}