class Solution {
    public int findMin(int[] nums) {
        int n = nums.length, low = 0, high = n - 1;
        if(nums[0] < nums[n - 1])
            return nums[0];
        while(low < high){
            int mid = low + (high - low) / 2;
            if(nums[mid] < nums[high])
                high = mid;
            else if(nums[mid] > nums[high])
                low = mid + 1;
            else
                high--;             //This is a bit confusing, dry run and do again       
        }
        return nums[low];
    }
}