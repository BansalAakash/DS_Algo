class Solution {
    int lower_bound(int val, int[] nums, int high){
        int low = 0, mid = 0;
        while(low < high){
            mid = low + (high - low) / 2;
            if(nums[mid] == val)
                return mid;
            else if(val >= nums[mid])
                low = mid + 1;
            else high = mid;
        }
        return low;
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length, bound = 0;
        int[] lis = new int[n];
        for(int val : nums)
            if(bound == 0 || val > lis[bound - 1])
                lis[bound++] = val;
            else
                lis[lower_bound(val, lis, bound - 1)] = val;
        return bound;
    }
}