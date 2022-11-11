class Solution {
    // int f(int[] nums, int i, int n, int prev){
    //     if(i == n)
    //         return 0;
    //     int result = f(nums, i + 1, n, prev);
    //     if(prev == -1 || nums[i] > nums[prev])
    //         result = Math.max(f(nums, i + 1, n, i) + 1, result);
    //     return result;
    // }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] ahead = new int[n + 1], cur = new int[n + 1];
        for(int i = n - 1;i >= 0;i--){
            for(int prev = i - 1;prev >= -1;prev--){
                cur[prev + 1] = ahead[prev + 1];
                if(prev == -1 || nums[i] > nums[prev])
                    cur[prev + 1] = Math.max(ahead[i + 1] + 1, ahead[prev + 1]);
            }
            ahead = cur;
        }
        return ahead[0];
    }
}