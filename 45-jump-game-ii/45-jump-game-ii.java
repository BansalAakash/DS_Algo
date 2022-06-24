class Solution {
    public int jump(int[] nums) {
        int maxI = 0, n = nums.length;
        if(n < 2)
            return 0;
        int[] jumps = new int[n];
        Arrays.fill(jumps, Integer.MAX_VALUE);
        jumps[0] = 0;
        for(int i = 0;i < n;i++){
            maxI = Math.max(maxI, i + nums[i]);
            if(maxI >= n - 1)
                return jumps[i] + 1;
            for(int j = i + 1;j <= Math.min(i + nums[i], n - 1);j++)
                jumps[j] = Math.min(jumps[j], jumps[i] + 1);
        }
        return jumps[n - 1];
    }
}