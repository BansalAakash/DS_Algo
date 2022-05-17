class Solution {
    public int maxProduct(int[] nums) {
        int iMax = 1, iMin = 1, max = Integer.MIN_VALUE;
        for(int i = 0;i < nums.length;i++){
            if(nums[i] < 0){
                int temp = iMax;
                iMax = iMin;
                iMin = temp;
            }
            iMax = Math.max(nums[i], iMax * nums[i]);
            iMin = Math.min(nums[i], iMin * nums[i]);
            max = Math.max(max, iMax);
        }
        return max;
    }
}