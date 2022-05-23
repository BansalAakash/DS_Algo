class Solution {
    public boolean isMonotonic(int[] nums) {
        if(nums.length < 2) return true;
        int n = nums.length;
        if(nums[0] >= nums[n - 1]){
            for(int i = 1;i < nums.length;i++)
                if(nums[i] > nums[i - 1]) return false;
        } else{
            for(int i = 1;i < nums.length;i++)
                if(nums[i] < nums[i - 1]) return false;
        }
        return true;
    }
}