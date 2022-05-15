class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE, curSum = 0;
        for(int i = 0;i < nums.length;i++){
            if(curSum + nums[i] < 0){
                maxSum = Math.max(curSum + nums[i], maxSum);
                curSum = 0;
            }
            else{
                maxSum = Math.max(curSum + nums[i], maxSum);
                curSum += nums[i];
            }
        }
        return maxSum;
    }
}