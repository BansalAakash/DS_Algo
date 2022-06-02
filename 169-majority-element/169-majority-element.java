class Solution {
    public int majorityElement(int[] nums) {
        int curElem = nums[0], count = 1, n = nums.length;
        for(int i = 1;i < n;i++){
            if(nums[i] == curElem) count++;
            else count--;
            if(count == 0){
                curElem = nums[i];
                count = 1;
            }
        }
        return curElem;
    }
}