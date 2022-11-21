class Solution {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);
        int low = 0, high = nums.length - 1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(nums[mid] == mid)
                low = mid + 1;
            else high = mid - 1;
        }
        return low;
    }
}