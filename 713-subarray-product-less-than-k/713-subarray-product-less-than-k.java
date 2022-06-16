class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if(k <= 1)
            return 0;
        int left = 0, right = 0, result = 0, product = 1, n = nums.length;
        while(right < n){
            product *= nums[right];
            while(product >= k)
                product /= nums[left++];
            result += right - left + 1;
            right++;
        }
        return result;
    }
}