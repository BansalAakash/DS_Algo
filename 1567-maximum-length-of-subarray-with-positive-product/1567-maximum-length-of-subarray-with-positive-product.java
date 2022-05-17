class Solution {
    int getMaxLen(int[] nums, int start, int end, int countNeg, int firstNeg, int lastNeg){
        if(countNeg % 2 == 0)
            return end - start + 1;
        return Math.max(lastNeg - start, end - firstNeg);
    }
    public int getMaxLen(int[] nums) {
        int i = 0, j = 0, max = 0, countNeg = 0, firstNeg = -1, lastNeg = -1, n = nums.length;
        while(i < n){
            while(j < n && nums[j] != 0){
                if(nums[j] < 0){
                    countNeg++;
                    firstNeg = (firstNeg == -1) ? j : firstNeg;
                    lastNeg = j;
                }
                j++;
            }
            if(j > i && j <= n)
                max = Math.max(max, getMaxLen(nums, i, j - 1, countNeg, firstNeg, lastNeg));
            firstNeg = -1; lastNeg = -1; countNeg = 0;
            j++;
            i = j;
        }
        return max;
    }
}