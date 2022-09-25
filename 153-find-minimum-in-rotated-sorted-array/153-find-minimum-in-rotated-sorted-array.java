class Solution {
    public int findMin(int[] nums) {
        int n = nums.length, low = 0, high = n - 1;
        if(n == 1 || nums[0] < nums[n - 1])
            return nums[0];
        while(low < high){
            int mid = low + (high - low) / 2;
            if(nums[mid] > nums[n - 1]) low = mid + 1;
            else high = mid;
        }
        return nums[low];
    }
}