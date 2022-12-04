class Solution {
    int binarySearch(int[] nums, int target, int flag, int n){     //0 means first, 1 means last
        int low = 0, high = n - 1, result = -1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(nums[mid] == target){
                result = mid;
                if(flag == 0)
                    high = mid - 1;
                else 
                    low = mid + 1;
            } else if(nums[mid] > target)
                high = mid - 1;
            else low = mid + 1;
        }
        return result;
    }
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int[] result = {-1, -1};
        if(n == 0 || target < nums[0] || target > nums[n - 1])
            return result;
        result[0] = binarySearch(nums, target, 0, n);
        result[1] = binarySearch(nums, target, 1, n);
        return result;
    }
}