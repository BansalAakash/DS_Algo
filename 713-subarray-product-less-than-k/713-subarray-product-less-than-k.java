class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int count = 0, i = 0, j = 0, n = nums.length;
        long product = 1;
        
        while(i < n){
            j = i;
            product = 1;
            while(j < n){
                product *= nums[j];
                if(product < k) count++;
                else break;
                j++;
            }
            i++;
        }
        return count;
    }
}