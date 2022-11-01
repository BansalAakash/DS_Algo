class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length, max = 0, maxIndex = -1;
        int[] dp = new int[n];
        int[] parent = new int[n];
        Arrays.sort(nums);
        Arrays.fill(parent, -1);
        for(int i = 0;i < n;i++){
            for(int j = i - 1;j >= 0;j--)
                if(nums[i] % nums[j] == 0 && dp[i] <= dp[j]){
                    dp[i] = dp[j];
                    parent[i] = j;
                }
            dp[i] += 1;
            if(dp[i] > max){
                max = dp[i];
                maxIndex = i;
            }
        }
        int i = maxIndex;
        LinkedList<Integer> result = new LinkedList<>();
        while(i != -1){
            result.addFirst(nums[i]);
            i = parent[i];
        }
        return result;
    }
}