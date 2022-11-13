class Solution {
    int f(int[] nums, int i, int j, int[][] dp){
        if(i > j)
            return 0;
        if(dp[i][j] != -1)
            return dp[i][j];
        int cost = Integer.MIN_VALUE;
        for(int k = i;k <= j;k++){
            int cur = nums[i - 1] * nums[k] * nums[j + 1] + f(nums, i, k - 1, dp)
                           +f(nums, k + 1, j, dp);
            cost = Math.max(cost, cur);
        }
        return dp[i][j] = cost;
    }
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] nums2 = new int[n + 2];
        nums2[0] = 1;
        nums2[n + 1] = 1;
        int i = 1;
        for (int j : nums)
            nums2[i++] = j;
        int[][] dp = new int[n + 2][n + 2];
        for(int[] row : dp)
            Arrays.fill(row, -1);
        return f(nums2, 1, n, dp);
    }
}