class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length(), i = 1, j = 1;
        boolean[] dp = new boolean[n + 1];
        
        dp[0] = true;
        while(j <= n && p.charAt(j - 1) == '*')
            dp[j++] = true;
        for(i = 1;i <= m;i++){
            boolean prev = false;
            dp[0] = false;
            if(i == 1)
                prev = true;
            for(j = 1;j <= n;j++){
                boolean temp = dp[j];
                if(s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?')
                    dp[j] = prev;
                else if(p.charAt(j - 1) == '*')
                    dp[j] = dp[j] | dp[j - 1];
                else dp[j] = false;
                prev = temp;
            }
        }
        return dp[n];
    }
}