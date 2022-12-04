class Solution {
    int binarySearch(int[] nums, int low, int high, int n){
        if(low == high)
            return low;
        int mid = low + (high - low) / 2;
        if(nums[mid] > (mid == n - 1 ? Integer.MIN_VALUE : nums[mid + 1]))
            return binarySearch(nums, low, mid, n);
        return binarySearch(nums, mid + 1, high, n);
    }
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        return binarySearch(nums, 0, n - 1, n);
    }
}