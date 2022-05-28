class Solution {
    String reverse(String s){
        StringBuilder str = new StringBuilder();
        for(int i = s.length() - 1;i >= 0;i--)
            str.append(s.charAt(i));
        return str.toString();
    }
    public int longestPalindromeSubseq(String s) {
        int n = s.length(), prev = 0;
        String rev = reverse(s);
        int[] dp = new int[n + 1];
        for(int i = 1;i <= n;i++){
            prev = 0;
            for(int j = 1;j <= n;j++){
                int temp = dp[j];
                dp[j] = Math.max(dp[j - 1], dp[j]);
                if(s.charAt(i - 1) == rev.charAt(j - 1))
                    dp[j] = Math.max(dp[j], prev + 1);
                prev = temp;
            }
        }
        return dp[n];
    }
}