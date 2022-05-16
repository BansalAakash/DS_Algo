class Solution {
    public int maxProduct(int[] nums) {
        int prefix = 0, suffix = 0, result = Integer.MIN_VALUE;
        for(int i = 0;i < nums.length;i++){
            prefix = (prefix == 0 ? 1 : prefix) * nums[i];
            suffix = (suffix == 0 ? 1 : suffix) * nums[nums.length - i - 1];
            result = Math.max(result, Math.max(prefix, suffix));
        }
        return result;
    }
}