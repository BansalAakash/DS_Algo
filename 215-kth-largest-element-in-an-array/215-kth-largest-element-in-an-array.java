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
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length, low = 0, high = n - 1, pivot = -1;
        k = n - k;             //kth largest means we need to return (n - k)th element
        
        while(low <= high){
            pivot = partition(nums, low, high);
            if(pivot == k) break;
            if(pivot < k) low = pivot + 1;
            else high = pivot - 1;
        }
        return nums[k];
    }
}