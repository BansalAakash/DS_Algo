class Solution {
    public int rob(int[] nums) {
        int r = 0, dnr = 0;
        for(int i : nums){
            int prev = r;
            r = dnr + i;
            dnr = Math.max(prev, dnr);
        }
        return Math.max(r, dnr);
    }
}