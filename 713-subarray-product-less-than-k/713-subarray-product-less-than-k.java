class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k <= 1) return 0;
        int left = 0, count = 0, product = 1, n = nums.length;
        for(int right = 0;right < n;right++){
            product *= nums[right];
            while(left <= right && product >= k) product /= nums[left++];
            count += right - left + 1;
        }
        return count;
    }
}