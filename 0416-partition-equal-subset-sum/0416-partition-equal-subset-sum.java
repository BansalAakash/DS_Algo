class Solution {
    boolean subsetSumEqualsK(int[] nums, int k, int n){
        boolean[] dp = new boolean[k + 1];
        dp[0] = true;
        for(int i = 1;i <= n;i++)
            for(int j = k;j >= 1;j--)
                if(j >= nums[i - 1])
                    dp[j] = dp[j] | dp[j - nums[i - 1]];
            
        return dp[k];
    }
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i : nums)
            sum += i;
        return sum % 2 == 1 ? false : subsetSumEqualsK(nums, sum / 2, nums.length);
    }
}