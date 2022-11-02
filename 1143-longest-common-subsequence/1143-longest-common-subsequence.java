class Solution {
    int helper(String s1, String s2, int i, int j, int m, int n, int[][] dp){
        if(i == m || j == n)
            return 0;
        if(dp[i][j] != -1)
            return dp[i][j];
        if(s1.charAt(i) == s2.charAt(j))
            return dp[i][j] = 1 + helper(s1, s2, i + 1, j + 1, m, n, dp);
        return dp[i][j] = Math.max(helper(s1, s2, i + 1, j, m, n, dp), helper(s1, s2, i, j + 1, m, n, dp));
    }
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        for(int[] row : dp)
            Arrays.fill(row, -1);
        return helper(text1, text2, 0, 0, text1.length(), text2.length(), dp);
    }
}