class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        if(nums.length < 3) return 0;
        int count = 0, cur = 1, i = 0, j = i + 2, n = nums.length;
        while(j < n){
            if(nums[j] - nums[j - 1] == nums[i + 1] - nums[i]){
                count += cur;
                cur += 1;
                j++;
            } else{
                j++;
                i = j - 2;
                cur = 1;
            }
        }
        return count;
    }
}