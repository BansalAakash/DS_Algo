class Solution {
    public void moveZeroes(int[] nums) {
        int k = 0, n = nums.length, i = 0;
        while(i < n){
            if(nums[i] != 0)
                nums[k++] = nums[i];
            i++;
        }
        for(i = k;i < n;i++)
            nums[i] = 0;
    }
}