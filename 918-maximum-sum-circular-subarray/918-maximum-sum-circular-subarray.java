class Solution {
int kadane(int[] nums, int sign){
        int cur = Integer.MIN_VALUE, ans = Integer.MIN_VALUE;
        for(int i : nums){
            cur = sign * i + Math.max(cur, 0);
            ans = Math.max(ans, cur);
        }
        return sign * ans;
    }

    public int maxSubarraySumCircular(int[] nums) {
        if(nums.length == 1) return nums[0];
        int total = 0;
        for(int i : nums) total += i;
        int maxSubarraySum = kadane(nums, 1);
        int minSubarraySum = kadane(nums, -1);
        return maxSubarraySum > 0 ? Math.max(maxSubarraySum, total - minSubarraySum) : maxSubarraySum;
    }
}