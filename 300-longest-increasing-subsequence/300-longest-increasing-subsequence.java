class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 1) return 1;
        int n = nums.length, max = Integer.MIN_VALUE;
        int[] dp =new int[n];
        dp[0] = 1;
        for(int i = 1;i < n;i++){
            int j = i - 1;
            while(j >= 0){
                if(nums[j] < nums[i])
                    dp[i] = Math.max(dp[j], dp[i]);
                j--;
            }
            dp[i] += 1;
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}