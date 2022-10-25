class Solution {
    void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    int quickSelect(int[] nums, int k, int low, int high){
        if(low > high)
            return -1;
        int pivot = low, i = low, j = high;
        while(i <= j){
            while(i <= j && nums[i] <= nums[pivot]) i++;
            while(i <= j && nums[j] > nums[pivot]) j--;
            if(i < j)
                swap(i, j, nums);
        }
        swap(j, pivot, nums);
        if(j == k)
            return nums[k];
        if(k < j)
            return quickSelect(nums, k, low, j - 1);
        return quickSelect(nums, k, j + 1, high);
    }
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        // System.out.println("Looking for " + (n - k) + "th element");
        return quickSelect(nums, n - k, 0, n - 1);
    }
}