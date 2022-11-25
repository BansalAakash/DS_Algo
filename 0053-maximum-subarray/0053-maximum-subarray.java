class Solution {
    public int maxSubArray(int[] nums) {
        int cur = 0, max = Integer.MIN_VALUE;
        for(int i : nums){
            cur = cur < 0 ? i : cur + i;
            max = Math.max(cur, max);
        }
        return max;
    }
}