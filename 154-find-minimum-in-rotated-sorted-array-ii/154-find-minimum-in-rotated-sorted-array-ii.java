class Solution {
    public int findMin(int[] nums) {
        int n = nums.length, low = 0, high = n - 1, mid = -1;
        while(low < high){
            mid = low + (high - low) / 2;
            if(nums[mid] < nums[high])
                high = mid;
            else if (nums[mid] > nums[high])
                low = mid + 1;
            else high--;
        }
        return nums[low];
    }
}