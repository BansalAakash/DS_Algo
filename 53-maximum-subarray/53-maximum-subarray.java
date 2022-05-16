class Solution {
    public int maxSubArray(int[] nums) {
        int cur = Integer.MIN_VALUE, ans = Integer.MIN_VALUE;
        for(int i : nums){
            cur = Math.max(0, cur) + i;
            ans = Math.max(cur, ans);
        }
        return ans;
    }
}