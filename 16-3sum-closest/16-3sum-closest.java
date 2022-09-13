class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length, sum = 0, diff = Integer.MAX_VALUE, i = 0, j = 1, k = n - 1;
        Arrays.sort(nums);
        while(i < n - 2){
            j = i + 1;
            k = n - 1;
            while(j < k){
                int tempSum = nums[i] + nums[j] + nums[k];
                if(Math.abs(tempSum - target) < diff){
                    sum = tempSum;
                    diff = Math.abs(sum - target);
                    if(diff == 0)
                        return sum;
                }
                if(tempSum > target)
                    k--;
                else j++;
            }
            i++;
        }
        return sum;
    }
}