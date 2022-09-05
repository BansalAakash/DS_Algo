class Solution {
    public int maxSubArray(int[] nums) {
        int curSum = 0, best = Integer.MIN_VALUE;
        for(int i = 0;i < nums.length;i++){
            if(curSum > 0)
                curSum += nums[i];
            else
                curSum = nums[i];
            best = Math.max(curSum, best);
        }
        return best;
    }
}