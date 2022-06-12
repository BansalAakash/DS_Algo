class Solution {
    int findPivot(int[] nums, int low, int high){
        if(low > high) return -1;
        int mid = low + (high - low) / 2;
        if(nums[mid] > (mid == 0 ? Integer.MIN_VALUE : nums[mid - 1]) && nums[mid] > (mid == nums.length - 1 ? Integer.MIN_VALUE : nums[mid + 1]))
            return mid;
        if(nums[mid] < nums[nums.length - 1]) return findPivot(nums, low, mid - 1);
        return findPivot(nums, mid + 1, high);
    }
    int binarySearch(int[] nums, int low, int high, int target){
        if(low > high) return -1;
        int mid = low + (high - low) / 2;
        if(nums[mid] == target) return mid;
        if(nums[mid] > target) return binarySearch(nums, low, mid - 1, target);
        return binarySearch(nums, mid + 1, high, target);
    }
    public int search(int[] nums, int target) {
        int n = nums.length;
        if(nums[0] < nums[n - 1])
            return binarySearch(nums, 0, n - 1, target);
        int pivot = findPivot(nums, 0, n - 1);
        if(target == nums[pivot]) return pivot;
        if(target < nums[pivot] && target >= nums[0])
            return binarySearch(nums, 0, pivot - 1, target);
        return binarySearch(nums, pivot + 1, n - 1, target);
    }
}