class Solution {
    public int maxSubArray(int[] nums) {
        int max_ending_here = 0, max_so_far = Integer.MIN_VALUE;
        for(int i = 0;i < nums.length;i++){
            if(nums[i] + max_ending_here < 0){
                max_so_far = Math.max(max_so_far, nums[i]);
                max_ending_here = 0;
            } else{
                max_ending_here += nums[i];
                max_so_far = Math.max(max_so_far, max_ending_here);
            }
        }
        return max_so_far;
    }
}