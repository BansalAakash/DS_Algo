class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        int rob = nums[0], dnr = 0;
        for(int i = 1;i < nums.length;i++){
            int temp_rob = rob;
            rob = nums[i] + dnr;
            dnr = Math.max(temp_rob, dnr);
        }
        return Math.max(rob, dnr);
    }
}