class Solution {
    public int singleNonDuplicate(int[] nums) {
        int n = nums.length, low = 0, high = n - 1, mid = 0;
        if(n == 1 || nums[0] != nums[1])
            return nums[0];
        if(nums[n - 1] != nums[n - 2])
            return nums[n - 1];
        while(low <= high){
            mid = low + (high - low) / 2;
            if(nums[mid] != nums[mid - 1] && nums[mid] != nums[mid + 1])
                return nums[mid];
            if((nums[mid] == nums[mid + 1] && mid % 2 == 0) || (nums[mid] == nums[mid - 1] && mid % 2 == 1))
                low = mid + 1;
            else high = mid - 1;
        }
        return nums[mid];
    }
}