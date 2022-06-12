class Solution {
    int binarySearch(int[] nums, int low, int high, int target, int direction){     //direction = 0: first, 1: last
        if(low > high) return -1;
        int mid = low + (high - low) / 2;
        if(nums[mid] == target){
            if(direction == 0){
                int left = binarySearch(nums, low, mid - 1, target, direction);
                return left == -1 ? mid : left;
            } else{
                int right = binarySearch(nums, mid + 1, high, target, direction);
                return right == -1 ? mid : right;
            }
        } else if(nums[mid] > target)
            return binarySearch(nums, low, mid - 1, target, direction);
        return binarySearch(nums, mid + 1, high, target, direction);
    }
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int first = binarySearch(nums, 0, n - 1, target, 0);
        int last = binarySearch(nums, 0, n - 1, target, 1);
        return new int[] {first, last};
    }
}