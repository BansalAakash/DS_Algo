class Solution {
    public int findTargetSumWays(int[] nums, int d) {
        int sum = 0, n = nums.length;
        for(int i : nums)
            sum += i;
        if(sum - d < 0 || (sum - d) % 2 != 0)
            return 0;
        int target = (sum - d) / 2;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for(int i = 1;i <= n;i++)
            for(int j = target;j >= 0;j--)
                if(j >= nums[i - 1])
                    dp[j] += dp[j - nums[i - 1]];
        return dp[target];
    }
}