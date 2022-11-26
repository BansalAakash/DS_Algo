class Solution {
    void reverse(int[] nums, int i, int j){
        while(i < j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
    void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void nextPermutation(int[] nums) {
        int n = nums.length, i = n - 2;
        
        while(i >= 0 && nums[i] >= nums[i + 1])
            i--;
        
        if(i == -1){                             //not possible
            reverse(nums, 0, n - 1);
            return;
        }
        
        int j = n - 1, min = Integer.MAX_VALUE, index = n - 1;
        while(j > i){
            if(nums[j] > nums[i] && nums[j] - nums[i] < min){
                min = nums[j] - nums[i];
                index = j;
            }
            j--;
        }
        swap(nums, i, index);
        reverse(nums, i + 1, n - 1);
    }
}