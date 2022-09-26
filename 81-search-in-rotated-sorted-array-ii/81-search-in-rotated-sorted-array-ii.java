class Solution {
    public boolean search(int[] nums, int target) {
        int low = 0, n = nums.length, high = n - 1, mid = -1;
        while(low < high){
            mid = low + (high - low) / 2;
            if(nums[mid] == target)
                return true;
            if(nums[mid] < nums[high]){         //right is sorted
                if(target > nums[mid] && target <= nums[high])
                    low = mid + 1;
                else high = mid - 1;
            }
            else if(nums[mid] > nums[high]){         //left is sorted
                if(target >= nums[low] && target < nums[mid])
                    high = mid - 1;
                else low = mid + 1;
            }
            else high--;
        }
        return nums[low] == target;
    }
}