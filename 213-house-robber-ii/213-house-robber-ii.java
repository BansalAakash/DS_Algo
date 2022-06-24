class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        int r = 0, dnr = 0;
        for(int i = 0;i < nums.length - 1;i++){
            int prev = r;
            r = dnr + nums[i];
            dnr = Math.max(prev, dnr);
        }
        int result1 = Math.max(r, dnr);
        int r1 = 0, dnr1 = 0;
        for(int i = 1;i < nums.length;i++){
            int prev = r1;
            r1 = dnr1 + nums[i];
            dnr1 = Math.max(prev, dnr1);
        }
        int result2 = Math.max(r1, dnr1);
        return Math.max(result1, result2);
    }
}