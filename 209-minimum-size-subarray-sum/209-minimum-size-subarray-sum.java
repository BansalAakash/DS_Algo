class Solution {
    public int minSubArrayLen(int k, int[] nums) {
        int left = 0, right = 0, n = nums.length, sum = 0, result = Integer.MAX_VALUE;
        while(right < n){
            sum += nums[right];
            while(sum >= k){
                result = Math.min(result, right - left + 1);
                sum -= nums[left++];
            }
            right++;
        }
        
        
        
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}