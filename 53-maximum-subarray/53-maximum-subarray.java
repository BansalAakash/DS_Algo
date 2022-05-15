class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE, curSum = 0;
        for(int i = 0;i < nums.length;i++){
            maxSum = Math.max(curSum + nums[i], maxSum);
            if(curSum + nums[i] < 0)
                curSum = 0;
            else
                curSum += nums[i];
        }
        return maxSum;
    }
}