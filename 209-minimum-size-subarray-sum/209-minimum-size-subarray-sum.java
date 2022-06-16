class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0, j = 0, result = Integer.MAX_VALUE, n = nums.length, sum = 0, flag = 0;
        while(i < n){
            if(sum < target){
                if(j < n){
                    sum += nums[j];
                    j++;
                } else break;
            } else {
                result = Math.min(result, j - i);
                sum -= nums[i];
                flag = 1;
                i++;
            }
        }
        return flag == 0 ? flag : result;
    }
}