class Solution {
    public int removeDuplicates(int[] nums) {
        int k = 1, i = 1, n = nums.length;
        if(n == 1)
            return k;
        while(i < n){
            while(i < n && nums[i - 1] == nums[i]) i++;
            if(i < n)
                nums[k++] = nums[i++];
        }
        return k;
    }
}