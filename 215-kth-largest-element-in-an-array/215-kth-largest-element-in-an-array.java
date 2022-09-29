class Solution {
    void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    int partition(int[] nums, int low, int high){               //we'll take low as pivot
        int i = low, j = high;
        while(i < j){
            while(i <= high && nums[i] <= nums[low]) i++;       //i goes from pivot + 1 to high
            while(j >= low && nums[j] > nums[low]) j--;          //j goes from high to pivot
            if(i < j)
                swap(nums, i, j);
        }
        swap(nums, low, j);                                     //j is the position of the pivot
        return j;
    }
    int quickSelect(int[] nums, int low, int high, int k){
        int pivot = partition(nums, low, high);
        if(pivot == k)
            return nums[pivot];
        if(pivot < k)
            return quickSelect(nums, pivot + 1, high, k);
        return quickSelect(nums, low, pivot - 1, k);
    }
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        k = n - k;             //kth largest means we need to return (n - k)th element
        return quickSelect(nums, 0, n - 1, k);
    }
}