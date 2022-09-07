class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for(int i = 0;i <= (n - 1) / 2;i++){
            if(nums[i + n / 2] == nums[i])
                return nums[i];
        }
        return -1;
    }
}