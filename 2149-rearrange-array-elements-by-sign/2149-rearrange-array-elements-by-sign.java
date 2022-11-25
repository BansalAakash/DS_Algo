class Solution {
    public int[] rearrangeArray(int[] nums) {
        int i = 0, n = nums.length, j = 0, k = 0;
        int[] arr = new int[n];
        while(k < n){
            while(nums[i] > 0) i++;
            while(nums[j] < 0) j++;
            arr[k++] = nums[j++];
            arr[k++] = nums[i++];
        }
        return arr;
    }
}