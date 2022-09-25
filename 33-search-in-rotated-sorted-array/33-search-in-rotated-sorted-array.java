class Solution {
    int findPivot(int[] nums){
        int n = nums.length, low = 0, high = n - 1, mid = -1;
        if(n == 1 || nums[0] < nums[n - 1])
            return 0;
        while(low < high){
            mid = low + (high - low) / 2;
            if(nums[mid] > nums[n - 1]) low = mid + 1;
            else high = mid;
        }
        return low;
    }
    int binarySearch(int[] nums, int target, int low, int high){
        int mid = -1;
        while(low <= high){
            mid = low + (high - low) / 2;
            if(nums[mid] == target) return mid;
            if(nums[mid] > target) high = mid - 1;
            else low = mid + 1;
        }
        return -1;
    }
    public int search(int[] nums, int target) {
        int pivot = findPivot(nums), n = nums.length;
        if(target >= nums[pivot] && target <= nums[n - 1])
            return binarySearch(nums, target, pivot, n - 1);
        return binarySearch(nums, target, 0, pivot - 1);
    }
}