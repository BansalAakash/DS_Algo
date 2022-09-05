class Solution {
    void swap(int[] A, int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
    public void sortColors(int[] nums) {
        int low = 0, high = nums.length - 1;
        for(int i = 0;i <= high;){
            if(nums[i] == 0){
                swap(nums, low, i);
                low++;
                i++;
            } else if(nums[i] == 2){
                swap(nums, i, high);
                high--;
            } else
                i++;
        }
    }
}