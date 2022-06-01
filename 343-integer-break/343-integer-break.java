class Solution {
    public int integerBreak(int n) {
        if(n == 0 || n == 1) return 0;
        if(n == 2) return 1;
        if(n == 3) return 2;
        if(n == 4) return 4;
        int[] dp = new int[n + 1];
        dp[2] = 2;
        dp[3] = 3;
        dp[4] = 4;
        for(int i = 5;i <= n;i++)
            dp[i] = Math.max(dp[i - 2] * 2, Math.max(dp[i - 3] * 3, dp[i - 4] * 4));
        return dp[n];
    }
}