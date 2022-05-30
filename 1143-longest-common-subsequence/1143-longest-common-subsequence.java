class Solution {
    int f(String text1, String text2, int m, int n, int[][] dp){
        if(m >= text1.length() || n >= text2.length()) return 0;
        if(dp[m][n] > 0) return dp[m][n];
        if(text1.charAt(m) == text2.charAt(n)) dp[m][n] = 1 + f(text1, text2, m + 1, n + 1, dp);
        else dp[m][n] = Math.max(f(text1, text2, m + 1, n, dp), f(text1, text2, m, n + 1, dp));
        return dp[m][n];
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m][n];
        int result = f(text1, text2, 0, 0, dp);
        // for(int[] row : dp)
        //     System.out.println(Arrays.toString(row));
        return result;
    }
}