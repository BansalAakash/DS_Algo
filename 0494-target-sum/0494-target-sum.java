class Solution {
    int helper(int[] nums, int index, int target){
        if(index == -1)
            return target == 0 ? 1 : 0;
        int add = helper(nums, index - 1, target - nums[index]);
        int sub = helper(nums, index - 1, target + nums[index]);
        return add + sub;
    }
    public int findTargetSumWays(int[] nums, int target) {
        return helper(nums, nums.length - 1, target);
    }
}