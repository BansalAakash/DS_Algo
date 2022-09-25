class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        if(n == 1)
            return nums[0];
        if(nums[0] < nums[n - 1])
            return nums[0];
        if(nums[n - 1] < nums[n - 2])
            return nums[n - 1];
        int low = 0, high = n - 1, mid = -1;
        while(low <= high){
            mid = low + (high - low) / 2;
            if(nums[mid] < nums[mid + 1] && nums[mid] < nums[mid - 1])
                return nums[mid];
            if(nums[mid] < nums[0])
                high = mid - 1;
            else low = mid + 1;
        }
        return nums[mid];
    }
}