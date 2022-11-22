class Solution {
    public int pivotIndex(int[] nums) {
        int sum = 0, n = nums.length, result = -1, suffixSum = 0;
        for(int i = 0 ;i < n;i++)
            sum += nums[i];
        for(int i = n - 1;i >= 0;i--){
            if(suffixSum == sum - nums[i] - suffixSum)
                result = i;
            suffixSum += nums[i];
        }
        
        return result;
        
    }
}