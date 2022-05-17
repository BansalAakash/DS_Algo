class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        int[] prefixArray = new int[n];
        int[] suffixArray = new int[n];
        prefixArray[0] = 1;
        suffixArray[n - 1] = 1;
        for(int i = 1;i < n;i++){
            prefixArray[i] = nums[i - 1] * prefixArray[i - 1];
            suffixArray[n - i - 1] = nums[n - i] * suffixArray[n - i];
        }
        for(int i = 0;i < n;i++)
            answer[i] = prefixArray[i] * suffixArray[i];
        return answer;
    }
}