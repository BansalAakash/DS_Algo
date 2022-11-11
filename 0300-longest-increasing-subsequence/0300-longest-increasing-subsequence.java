class Solution {
    // int f(int[] nums, int i, int n, int prev){
    //     if(i == n)
    //         return 0;
    //     int result = f(nums, i + 1, n, prev);
    //     if(prev == -1 || nums[i] > nums[prev])
    //         result = Math.max(f(nums, i + 1, n, i) + 1, result);
    //     return result;
    // }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n + 1][n + 1];
        for(int i = n - 1;i >= 0;i--){
            for(int prev = i - 1;prev >= -1;prev--){
                dp[i][prev + 1] = dp[i + 1][prev + 1];
                if(prev == -1 || nums[i] > nums[prev])
                    dp[i][prev + 1] = Math.max(dp[i + 1][i + 1] + 1, dp[i + 1][prev + 1]);
            }
        }
        return dp[0][0];
    }
}