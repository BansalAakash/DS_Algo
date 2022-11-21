class Solution {
    public boolean check(int[] nums) {
        boolean flag = false;
        int n = nums.length;
        for(int i = 0;i < n;i++){
            if(nums[i] < nums[(i + n - 1) % n]){
                if(flag)
                    return false;
                flag = true;
            }
        }
        return true;
    }
}