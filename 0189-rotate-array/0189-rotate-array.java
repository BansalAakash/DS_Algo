class Solution {
    void invert(int[] nums, int low, int high){
        int i = low, j = high;
        while(i < j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        invert(nums, 0, n - 1);
        invert(nums, 0, k - 1);
        invert(nums, k, n - 1);
    }
}