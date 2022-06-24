class Solution {
    public int jump(int[] nums) {
        int n = nums.length, jumps = 0, curLevelEnd = 0, maxI = 0;
        if(n < 2)
            return 0;
        for(int i = 0;i < n;i++){
            maxI = Math.max(maxI, i + nums[i]);
            if(maxI >= n - 1)
                return jumps + 1;
            if(i == curLevelEnd){
                curLevelEnd = maxI;
                jumps++;
            }
        }
        return jumps;
    }
}