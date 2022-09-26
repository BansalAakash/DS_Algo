class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length, low = 0, high = n - 1, mid = -1;
        while(low <= high){
            mid = low + (high - low) / 2;
            if(nums[mid] == target)
                return mid;
            if(nums[low] <= nums[mid]){          //left is sorted
                if(target >= nums[low] && target < nums[mid])
                    high = mid - 1;
                else low = mid + 1;
            }
            else {          //right is sorted
                if(target <= nums[high] && target > nums[mid])
                    low = mid + 1;
                else high = mid - 1;
            }
        }
        return -1;
    }
}