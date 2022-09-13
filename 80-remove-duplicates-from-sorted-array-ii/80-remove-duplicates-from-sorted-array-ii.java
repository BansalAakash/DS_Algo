class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 1, i = 1, n = nums.length, cur = 1;
        if(n < 3)
            return n;
        while(i < n){
            if(nums[i] == nums[i - 1]){
                if(cur < 2){
                    cur++;
                    nums[k++] = nums[i];
                }
            } else{
                cur = 1;
                nums[k++] = nums[i];
            }
            i++;
        }
        return k;
    }
}