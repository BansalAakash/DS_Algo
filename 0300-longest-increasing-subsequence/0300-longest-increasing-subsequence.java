import java.util.*;
class Solution {
	int helper(int[] nums, int index, int prev, int n, int[][] dp){
		if(index == n)
			return 0;
		if(dp[index][prev + 1] != -1)
			return dp[index][prev + 1];
		int len = helper(nums, index + 1, prev, n, dp);
		if(prev == -1 || nums[index] > nums[prev]) 
			len = Math.max(len, 1 + helper(nums, index + 1, index, n, dp));
		dp[index][prev + 1] = len;
		return len;
	}
    public int lengthOfLIS(int[] nums) {
    	int n = nums.length;
    	int[][] dp = new int[n][n + 1];
    	for(int[] row : dp)
    		Arrays.fill(row, -1);
        return helper(nums, 0, -1, n, dp);
    }
    public static void main(String[] args) {
    	Solution s = new Solution();
    	int[] nums = {10,9,2,5,3,7,101,18};
    	System.out.println(s.lengthOfLIS(nums));
    }
}