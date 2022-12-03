class Solution {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length, low = 0, high = n - 1, index = -1;
        if(target > nums[high])
            return high + 1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] >= target){
                index = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return index;
    }
}