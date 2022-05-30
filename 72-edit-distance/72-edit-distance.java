class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[] dp = new int[n + 1];
        for(int i = 1;i <= n;i++)
            dp[i] = i;
        for(int i = 1;i <= m;i++){
            int prev = i - 1;
            dp[0] = i;
            for(int j = 1;j <= n;j++){
                int temp = dp[j];
                if(word1.charAt(i - 1) == word2.charAt(j - 1)) dp[j] = prev;
                else
                    dp[j] = Math.min(dp[j], Math.min(prev, dp[j - 1])) + 1;
                prev = temp;
            }
        }
        return dp[n];
    }
}