class Solution {
    int merge(int[] nums, int low, int mid, int high){
        int i = low, j = mid + 1, k = 0, count = 0;
        int[] temp = new int[high - low + 1];
        while(i <= mid){
            while(j <= high && (nums[j] < Integer.MIN_VALUE / 2 || (nums[j] <= Integer.MAX_VALUE / 2 && nums[i] > 2 * nums[j])))
                j++;
            count += j - (mid + 1);
            i++;
        }
        i = low;
        j = mid + 1;
        while(i <= mid || j <= high)
            if(i > mid || (j <= high && nums[j] < nums[i]))
                temp[k++] = nums[j++];
            else temp[k++] = nums[i++];
        for(i = low, j = 0;i <= high;i++,j++)
            nums[i] = temp[j];
        return count;
    }
    int mergeSort(int[] nums, int low, int high){
        if(low == high)
            return 0;
        int mid = low + (high - low) / 2, count = 0;
        count += mergeSort(nums, low, mid);
        count += mergeSort(nums, mid + 1, high);
        count += merge(nums, low, mid, high);
        return count;
    }
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }
}