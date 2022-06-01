class Solution {
    public int numSquares(int n) {
        if(n < 2) return 1;
        if(Math.sqrt(n) - Math.floor(Math.sqrt(n)) == 0) return 1;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for(int i = 2;i <= n;i++){
            if(Math.sqrt(i) - Math.floor(Math.sqrt(i)) == 0) dp[i] = 1;
            else{
                int start = 1, end = i - 1;
                dp[i] = dp[start++] + dp[end--];
                while(start <= end){
                    dp[i] = Math.min(dp[i], dp[start++] + dp[end--]);
                }
            }
        }
        return dp[n];
    }
}