class Solution {
    public int longestCommonSubsequence(String s1, String s2) {
        int m = s1.length(), n = s2.length(), prev = -1;
        int[] dp = new int[n + 1];
        for(int i = 1;i <= m;i++){
            prev = 0;
            for(int j = 1;j <= n;j++){
                int temp = dp[j];
                if(s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[j] = 1 + prev;
                else dp[j] = Math.max(dp[j], dp[j - 1]);
                prev = temp;
            }
        }
        return dp[n];
    }
}