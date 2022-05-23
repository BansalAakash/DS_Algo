class Solution {
    public boolean isMonotonic(int[] nums) {
        if(nums.length < 2) return true;
        int n = nums.length;
        int sign = 0;
        for(int i = 1;i < nums.length;i++){
            int curSign = Integer.compare(nums[i], nums[i - 1]);
            if(sign != 0 && curSign != 0 && curSign != sign) return false;
            if(curSign != 0)
                sign = curSign;
        }
        return true;
    }
}