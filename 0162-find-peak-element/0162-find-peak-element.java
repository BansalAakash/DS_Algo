class Solution {
    boolean isPeak(int[] nums, int i, int n){
        if(n == 1)
            return true;
        if(i == n - 1){
            if(nums[i] > nums[i - 1])
                return true;
            else return false;
        }
        if(i == 0){
            if(nums[i] > nums[i + 1])
                return true;
            else return false;
        }
        return nums[i] > Math.max(nums[i - 1], nums[i + 1]);
    }
    int binarySearch(int[] nums, int low, int high, int n){
        if(low > high)
            return -1;
        int mid = low + (high - low) / 2;
        if(isPeak(nums, mid, n))
            return mid;
        return Math.max(binarySearch(nums, low, mid - 1, n), binarySearch(nums, mid + 1, high, n));
    }
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        return binarySearch(nums, 0, n - 1, n);
    }
}