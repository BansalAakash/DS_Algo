class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0, cur = 0;
        for(int i : nums){
            if(i == 1){
                cur++;
                max = Math.max(max, cur);
            } else cur = 0;
        }
        return max;
    }
}