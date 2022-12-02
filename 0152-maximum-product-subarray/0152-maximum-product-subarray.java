class Solution {
    public int maxProduct(int[] nums) {
        int max = 1, min = 1, result = Integer.MIN_VALUE;
        for(int i : nums){
            if(i < 0){
                int temp = max;
                max = min;
                min = temp;
            }
            max = Math.max(i, i * max);
            min = Math.min(i, i * min);
            result = Math.max(result, max);
        }
        return result;
    }
}