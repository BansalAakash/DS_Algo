class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length(), i = 1, j = 1;
        boolean[][] dp = new boolean[m + 1][n + 1];
        
        dp[0][0] = true;
        while(j <= n && p.charAt(j - 1) == '*')
            dp[0][j++] = true;
        
        for(i = 1;i <= m;i++)
            for(j = 1;j <= n;j++)
                if(s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?')
                    dp[i][j] = dp[i - 1][j - 1];
                else if(p.charAt(j - 1) == '*')
                    dp[i][j] = dp[i - 1][j] | dp[i][j - 1];
        return dp[m][n];
    }
}