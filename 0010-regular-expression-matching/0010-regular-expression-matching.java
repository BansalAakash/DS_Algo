class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for(int j = 1;j <= n;j++)
            if(p.charAt(j - 1) == '*')
                dp[j] = dp[j - 2];
        for(int i = 1;i <= m;i++){
            boolean prev = false;
            dp[0] = false;
            if(i == 1)
                prev = true;
            for(int j = 1;j <= n;j++){
                boolean temp = dp[j];
                if(s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '.')
                    dp[j] = prev;
                else if(p.charAt(j - 1) == '*'){
                    if(s.charAt(i - 1) == p.charAt(j - 2) || p.charAt(j - 2) == '.')
                        dp[j] = dp[j] | (dp[j - 1] | dp[j - 2]);
                    else dp[j] = dp[j - 1] | dp[j - 2];
                }
                else dp[j] = false;
                prev = temp;
            }
        }
        return dp[n];
    }
}