class Solution {
    int helper(int index, char[] ch, int[] dp){
        if(index == ch.length) return 1;
        if(dp[index] > 0) return dp[index];
        else if(ch[index] == '0') dp[index] = 0;
        else if(index < ch.length - 1 && (ch[index] == '1' || (ch[index] == '2' && ch[index + 1] >= '0' && ch[index + 1] <= '6')))
            dp[index] = helper(index + 1, ch, dp) + helper(index + 2, ch, dp);
        else dp[index] =  helper(index + 1, ch, dp);
        return dp[index];
    }
    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        helper(0, s.toCharArray(), dp);
        return dp[0];
    }
}