class Solution {
    String reverse(String s){
        StringBuilder str = new StringBuilder();
        for(int i = s.length() - 1;i >= 0;i--)
            str.append(s.charAt(i));
        return str.toString();
    }
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        String rev = reverse(s);
        int[][] dp = new int[n + 1][n + 1];
        for(int i = 1;i <= n;i++){
            for(int j = 1;j <= n;j++){
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                if(s.charAt(i - 1) == rev.charAt(j - 1))
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
            }
        }
        return dp[n][n];
    }
}