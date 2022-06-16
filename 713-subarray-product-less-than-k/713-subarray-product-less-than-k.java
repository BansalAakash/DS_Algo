class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k == 0)
            return 0;
        int left = 0, right = 0, result = 0, product = 1, n = nums.length;
        while(right < n){
            product *= nums[right];
            while(product >= k && left <= right)
                product /= nums[left++];
            result += right - left + 1;
            right++;
        }
        return result;
    }
}