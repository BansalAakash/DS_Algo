class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length(), prev;
        int[] dp = new int[n + 1];
        for(int i = 1;i <= m;i++){
            prev = 0;
            for(int j = 1;j <= n;j++){
                int temp = dp[j];
                dp[j] = Math.max(dp[j - 1], dp[j]);
                if(text1.charAt(i - 1) == text2.charAt(j - 1))
                    dp[j] = Math.max(dp[j], prev + 1);
                prev = temp;
            }
        }
        return dp[n];
    }
}