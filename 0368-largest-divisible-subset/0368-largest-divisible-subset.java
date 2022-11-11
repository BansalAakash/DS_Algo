class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length, maxI = 0, max = 1;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int[] parent = new int[n];
        Arrays.fill(parent, -1);
        for(int i = 1;i < n;i++)
            for(int j = 0;j < i;j++)
                if(nums[i] % nums[j] == 0 && dp[i] <= dp[j]){
                    dp[i] = dp[j] + 1;
                    parent[i] = j;
                    if(dp[i] > max){
                        max = dp[i];
                        maxI = i;
                    }
                }
        LinkedList<Integer> list = new LinkedList<>();
        while(maxI != -1){
            list.addFirst(nums[maxI]);
            maxI = parent[maxI];
        }
        return list;
    }
}