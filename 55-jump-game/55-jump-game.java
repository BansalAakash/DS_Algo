class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n];
        dp[0] = true;
        
        for(int i = 0;i < n;i++){
            if(!dp[i])
                return false;
            for(int j = i + 1;j <= Math.min(i + nums[i], n - 1);j++)
                dp[j] = true;
        }
        return true;
    }
}