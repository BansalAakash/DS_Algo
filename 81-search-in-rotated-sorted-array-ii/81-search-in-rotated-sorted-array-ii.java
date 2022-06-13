class Solution {
    boolean binarySearch(int[] nums, int low, int high, int target){
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(nums[mid] == target)
                return true;
            if(nums[mid] > target) high = mid - 1;
            else low = mid + 1;
        }
        return false;
    }
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        if(n == 0) return nums[0] == target;
        if(nums[0] >= nums[n - 1]){
            int pivot = -1, low = 0, high = n - 1;
            while(low < high){
                int mid = low + (high - low) / 2;
                if(nums[mid] < nums[high])
                    high = mid;
                else if(nums[mid] > nums[high])
                    low = mid + 1;
                else{
                    if(nums[high] < nums[high - 1]){
                        pivot = high;
                        break;
                    } else 
                        high--;
                }
            }
            pivot = pivot == -1 ? low : pivot;
            if(target >= nums[0])
                return binarySearch(nums, 0, pivot, target);
            else return binarySearch(nums, pivot, n - 1, target);
        } else return binarySearch(nums, 0, n - 1, target);
        
    }
}