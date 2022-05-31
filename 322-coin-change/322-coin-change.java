class Solution {
    int helper(int[] coins, int amount, int[] dp) {
        if(amount == 0) return 0;
        if(amount < 0) return -1;
        if(dp[amount] != 0) return dp[amount];
        int min_ = Integer.MAX_VALUE;
        for(int i : coins){
            int temp = Math.min(min_, helper(coins, amount - i, dp));
            if(temp != -1)
                min_ = Math.min(min_, temp);
        }
        if(min_ == Integer.MAX_VALUE) return dp[amount] = -1;
        else dp[amount] = 1 + min_;
        return dp[amount];
    }
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.sort(coins);
        int result = helper(coins, amount, dp);
        return result;
    }
}