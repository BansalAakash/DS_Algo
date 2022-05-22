class Solution {
    int helper(int n, int[] dp){
        if(n < 2) return 1;
        if(dp[n] > 0) return dp[n];
        int sum = 0;
        for(int i = 0;i < n;i++)
            sum += helper(i, dp) * helper(n - i - 1, dp);
        dp[n] = sum;
        return dp[n];
    }
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        return helper(n, dp);
    }
}