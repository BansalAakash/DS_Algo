class Solution {
    public int majorityElement(int[] nums) {
        int elem = nums[0], cur = 1, max = 1, n = nums.length;
        for(int i = 1;i < n;i++){
            if(nums[i] == elem)
                cur++;
            else {
                cur--;
                if(cur == 0){
                    elem = nums[i];
                    cur = 1;
                }
            }
            max = Math.max(max, cur);
        }
        return elem;
    }
}