class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0], cur = nums[0];
        for(int i = 1;i < nums.length;i++){
            if(nums[i] + cur > nums[i])
                cur += nums[i];
            else cur = nums[i];
            max = Math.max(cur, max);
        }
        return max;
    }
}