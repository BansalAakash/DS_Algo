class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 1, n = nums.length, i = 1;
        while(i < n){
            if(nums[i] != nums[k - 1])
                nums[k++] = nums[i];
            i++;
        }
        return k;
    }
}