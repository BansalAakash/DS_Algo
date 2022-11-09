class Solution {
    boolean f(int i, int j, String s, String p, int[][] dp){
        if(i == -1){
            if(j == -1)
                return true;
            if(p.charAt(j) == '*')
                return f(i, j - 1, s, p, dp);
            return false;
        }
        if(j == -1)
            return false;
        if(dp[i][j] != -1)
            return dp[i][j] == 0 ? false : true;
        boolean result = false;
        if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')
            result = f(i - 1, j - 1, s, p, dp);
        if(p.charAt(j) == '*')
            result = f(i - 1, j, s, p, dp) | f(i, j - 1, s, p, dp);
        dp[i][j] = result ? 1 : 0;
        return result;
    }
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        int[][] dp = new int[m][n];
        for(int[] row : dp)
            Arrays.fill(row, -1);
        return f(m - 1, n - 1, s, p, dp);
    }
}